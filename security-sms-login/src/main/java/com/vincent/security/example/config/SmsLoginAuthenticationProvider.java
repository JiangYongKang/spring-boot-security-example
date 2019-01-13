package com.vincent.security.example.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * Author: vincent
 * Date: 2019-01-13 23:33:00
 * Comment:
 */

public class SmsLoginAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.isInstanceOf(SmsLoginAuthenticationToken.class, authentication, "类型不匹配");
        SmsLoginAuthenticationToken smsLoginAuthenticationToken = (SmsLoginAuthenticationToken) authentication;
        String mobile = String.valueOf(smsLoginAuthenticationToken.getPrincipal());
        UserDetails userDetails = userDetailsService.loadUserByUsername(mobile);
        if (userDetails == null)
            throw new InternalAuthenticationServiceException("无法通过手机号码获取用户信息");
        SmsLoginAuthenticationToken authenticationResult = new SmsLoginAuthenticationToken(mobile, userDetails.getAuthorities());
        authenticationResult.setDetails(smsLoginAuthenticationToken.getDetails());
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsLoginAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
