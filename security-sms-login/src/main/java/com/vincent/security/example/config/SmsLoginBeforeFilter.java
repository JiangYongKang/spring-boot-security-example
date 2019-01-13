package com.vincent.security.example.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: vincent
 * Date: 2019-01-13 23:45:00
 * Comment:
 */

@Component
public class SmsLoginBeforeFilter extends OncePerRequestFilter implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);
    }

}
