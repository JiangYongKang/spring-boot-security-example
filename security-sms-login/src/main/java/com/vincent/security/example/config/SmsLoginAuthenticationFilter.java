package com.vincent.security.example.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: vincent
 * Date: 2019-01-13 23:21:00
 * Comment:
 */

public class SmsLoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String FORM_MOBILE_PARAM_NAME = "mobile";

    public SmsLoginAuthenticationFilter() {
        super(new AntPathRequestMatcher("/authentication/mobile", HttpMethod.POST.name()));
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        if (request.getMethod().equalsIgnoreCase(HttpMethod.POST.name())) {
            String mobile = this.obtainMobile(request);
            SmsLoginAuthenticationToken authenticationToken = new SmsLoginAuthenticationToken(mobile);
            authenticationToken.setDetails(authenticationDetailsSource.buildDetails(request));
            return this.getAuthenticationManager().authenticate(authenticationToken);
        }

        throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
    }

    private String obtainMobile(HttpServletRequest request) {
        return request.getParameter(FORM_MOBILE_PARAM_NAME).trim();
    }
}
