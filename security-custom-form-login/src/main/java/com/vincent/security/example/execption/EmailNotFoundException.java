package com.vincent.security.example.execption;

import org.springframework.security.core.AuthenticationException;

/**
 * Author: vincent
 * DateTime: 2019/1/15 23:47
 * Comment:
 */

public class EmailNotFoundException extends AuthenticationException {

    public EmailNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public EmailNotFoundException(String msg) {
        super(msg);
    }
}
