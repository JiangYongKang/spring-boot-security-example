package com.vincent.security.session.controller;

import com.vincent.security.session.model.Member;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Author: vincent
 * Date: 2019-01-12 11:09:00
 * Comment:
 */

@RestController
@RequestMapping("/members")
public class MembersController {

    @GetMapping
    public void index(@Valid Member member) {
        System.out.println(ReflectionToStringBuilder.toString(new Member(), ToStringStyle.JSON_STYLE));
    }


}
