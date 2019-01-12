package com.vincent.security.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author: vincent
 * Date: 2019-01-12 16:39:00
 * Comment:
 */

@Configuration
public class SessionSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        // 最基本的验证
//        httpSecurity.httpBasic()
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();

        // 基于表单进行验证
        httpSecurity.formLogin()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
