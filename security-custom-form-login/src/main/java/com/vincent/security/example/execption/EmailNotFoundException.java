package com.vincent.security.example.execption;

import org.springframework.security.core.AuthenticationException;

/**
 * Author: vincent
 * DateTime: 2019/1/15 23:47
 * Comment: AuthenticationException 是 Spring Security 框架中的异常基类，我们自定义权限相关的异常，应该以它作为父类。
 */

public class EmailNotFoundException extends AuthenticationException {

    public EmailNotFoundException(String msg) {
        super(msg);
    }
}
