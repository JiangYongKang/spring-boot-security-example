package com.vincent.security.example.service.impl;

import com.vincent.security.example.mapper.UserMapper;
import com.vincent.security.example.model.User;
import com.vincent.security.example.service.AuthenticationService;
import com.vincent.security.example.util.TokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Author: vincent
 * Date: 2018-06-12 17:28:00
 * Comment:
 */

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private TokenUtil tokenUtil;

    @Resource
    private UserMapper mapper;

    @Override
    public User register(String username, String password) {
        if (mapper.findByUsername(username) != null) {
            return null;
        }
        User user = new User();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setLastPasswordResetDate(new Date());
        user.setId(mapper.save(user));
        return user;
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return tokenUtil.generateToken(userDetails);
    }

    @Override
    public String refresh(String token) {
        token = token.substring(TokenUtil.TOKEN_PREFIX.length());
        String username = tokenUtil.getUsernameFromToken(token);
        User user = (User) userDetailsService.loadUserByUsername(username);
        if (tokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            return tokenUtil.refreshToken(token);
        }
        return null;
    }
}
