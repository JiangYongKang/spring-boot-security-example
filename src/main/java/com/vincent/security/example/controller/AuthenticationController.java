package com.vincent.security.example.controller;

import com.vincent.security.example.model.AuthenticationRequestBean;
import com.vincent.security.example.model.AuthenticationResponseBean;
import com.vincent.security.example.model.User;
import com.vincent.security.example.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * Author: vincent
 * Date: 2018-06-12 17:11:00
 * Comment:
 */

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Resource
    private AuthenticationService authenticationService;

    /**
     * 创建用户
     * @param authenticationRequestBean
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<User> create(@RequestBody AuthenticationRequestBean authenticationRequestBean) {
        String username = authenticationRequestBean.getUsername();
        String password = authenticationRequestBean.getPassword();
        User user = authenticationService.register(username, password);
        return ResponseEntity.ok(user);
    }

    /**
     * 登录
     * @param authenticationRequestBean
     * @return
     */
    @PostMapping
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestBean authenticationRequestBean) {
        String username = authenticationRequestBean.getUsername();
        String password = authenticationRequestBean.getPassword();
        String token = authenticationService.login(username, password);
        return ResponseEntity.ok(token);
    }

    /**
     * 刷新 token
     * @param request
     * @return
     */
    @PutMapping("/refresh")
    public ResponseEntity<?> update(HttpServletRequest request) {
        String outdatedToken = request.getHeader(AUTHORIZATION);
        String freshToken = authenticationService.refresh(outdatedToken);
        return ResponseEntity.ok(new AuthenticationResponseBean(freshToken));
    }
}
