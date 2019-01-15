package com.vincent.security.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * Author: vincent
 * DateTime: 2019/1/15 21:27
 * Comment:
 */

@Slf4j
@Configuration
public class CustomFormLoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.formLogin().and()

                .authorizeRequests()
                .antMatchers("/index.html", "/login.html").permitAll()

                // 案例中 h2 web console 不加权限，便于调试
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest()
                .authenticated();

        // 关闭跨域相关的验证，否则 h2 web console 无法访问
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
