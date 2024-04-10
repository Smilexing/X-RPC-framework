package com.smile.example.common.service;

import com.smile.example.common.model.User;

/**
 * @author Tom Smile
 * @version 1.0
 * @description: TODO
 * @date 2024/4/8 23:32
 */
public interface UserService {
    /**
     * 获取用户
     *
     * @param user
     * @return
     */
    User getUser(User user);

    /**
     * 用于测试 mock 接口返回值
     *
     * @return
     */
    default short getNumber() {
        return 1;
    }
}
