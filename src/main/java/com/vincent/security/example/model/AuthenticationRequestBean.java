package com.vincent.security.example.model;

import java.io.Serializable;

/**
 * Author: vincent
 * Date: 2018-06-12 17:45:00
 * Comment:
 */

public class AuthenticationRequestBean implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;

    public AuthenticationRequestBean() {
        super();
    }

    public AuthenticationRequestBean(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
