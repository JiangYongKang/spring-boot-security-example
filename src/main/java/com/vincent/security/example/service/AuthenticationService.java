package com.vincent.security.example.service;

import com.vincent.security.example.model.User;

import java.util.Optional;

/**
 * Author: vincent
 * Date: 2018-06-12 17:28:00
 * Comment:
 */

public interface AuthenticationService {

    /**
     * 创建用户并加密密码
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User register(String username, String password);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    String login(String username, String password);

    /**
     * 刷新 token
     * @param token
     * @return
     */
    String refresh(String token);
}
