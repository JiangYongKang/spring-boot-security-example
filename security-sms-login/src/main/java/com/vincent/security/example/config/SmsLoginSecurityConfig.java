package com.vincent.security.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Author: vincent
 * Date: 2019-01-13 20:52:00
 * Comment:
 */

@Configuration
public class SmsLoginSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Resource
    private SmsLoginAuthenticationSuccessHandler smsLoginAuthenticationSuccessHandler;

    @Resource
    private SmsLoginAuthenticationFailureHandler smsLoginAuthenticationFailureHandler;

    @Override
    public void configure(HttpSecurity httpSecurity) {
        AuthenticationManager authenticationManager = httpSecurity.getSharedObject(AuthenticationManager.class);

        SmsLoginAuthenticationFilter smsLoginAuthenticationFilter = new SmsLoginAuthenticationFilter();
        smsLoginAuthenticationFilter.setAuthenticationManager(authenticationManager);
        smsLoginAuthenticationFilter.setAuthenticationSuccessHandler(smsLoginAuthenticationSuccessHandler);
        smsLoginAuthenticationFilter.setAuthenticationFailureHandler(smsLoginAuthenticationFailureHandler);

        httpSecurity.authenticationProvider(new SmsLoginAuthenticationProvider())
                .addFilterAfter(smsLoginAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
