package com.smile.example.provider;


import com.smile.config.RpcConfig;
import com.smile.example.common.model.User;
import com.smile.example.common.service.UserService;
import com.smile.proxy.ServiceProxyFactory;
import com.smile.utils.ConfigUtils;

/**
 * 简易服务提供者示例
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @learn <a href="https://codefather.cn">编程宝典</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public class EasyConsummerExample {

    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("yupi");
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());

        } else {
            System.out.println("user==null");

        }
    }
}
