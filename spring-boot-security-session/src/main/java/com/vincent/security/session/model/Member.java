package com.vincent.security.session.model;

import com.vincent.security.session.validator.MyValidator;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Author: vincent
 * Date: 2019-01-12 11:09:00
 * Comment:
 */

@Data
public class Member {

    @MyValidator
    private String email;

    private String password;

}
