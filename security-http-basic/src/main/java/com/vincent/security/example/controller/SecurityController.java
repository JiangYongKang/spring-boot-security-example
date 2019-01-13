package com.vincent.security.example.controller;

import com.vincent.security.example.common.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: vincent
 * Date: 2019-01-13 13:15:00
 * Comment:
 */

@Slf4j
@RestController
@RequestMapping("/security")
public class SecurityController extends BaseController {

    /**
     * 获取当前系统时间，需要登录后才可以访问
     * @return
     */
    @GetMapping("/timestamp")
    public ResponseEntity<?> currentTimestamp() {
        log.info(currentUser().toString());
        return super.success("当前系统时间：" + System.currentTimeMillis());
    }

    /**
     * 获取当前登录的用户
     * @return
     */
    public Authentication currentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
