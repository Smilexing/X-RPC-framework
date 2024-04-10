package com.smile.proxy;


import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.smile.model.RpcRequest;
import com.smile.model.RpcResponse;
import com.smile.serializer.JdkSerializer;
import com.smile.serializer.Serializer;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Tom Smile
 * @version 1.0
 * @description: TODO
 * @date 2024/4/9 10:18
 */
public class ServiceProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Serializer serializer = new JdkSerializer();
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .parameterTypes(method.getParameterTypes())
                .args(args)
                .build();
        try {
            byte[] Bodybytes = serializer.serialize(rpcRequest);
            try (HttpResponse httpResponse = HttpRequest.post("localhost:8080")
                    .body(Bodybytes)
                    .execute()) {
                byte[] result = httpResponse.bodyBytes();
                RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
                return rpcResponse.getData();
            }
        }catch (IOException e) {
                e.printStackTrace();
            }

        return null;
    }
}
