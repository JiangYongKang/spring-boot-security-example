package com.vincent.security.example.model;

import java.io.Serializable;

/**
 * Author: vincent
 * Date: 2018-06-12 17:49:00
 * Comment:
 */

public class AuthenticationResponseBean implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public AuthenticationResponseBean(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
