package com.smile.proxy;

import java.lang.reflect.Proxy;

/**
 * @author Tom Smile
 * @version 1.0
 * @description: TODO
 * @date 2024/4/9 12:34
 */
public class ServiceProxyFactory {
    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy()
        );
    }
}

