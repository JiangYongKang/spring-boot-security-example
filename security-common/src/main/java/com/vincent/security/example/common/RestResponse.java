package com.vincent.security.example.common;

import lombok.Data;

/**
 * Author: vincent
 * Date: 2019-01-13 13:20:00
 * Comment:
 */

@Data
public class RestResponse {

    private String code;
    private String message;
    private Object data;

    public RestResponse() {
        this.code = "200";
        this.message = "success";
    }

    public RestResponse(Object data) {
        this();
        this.data = data;
    }
}
