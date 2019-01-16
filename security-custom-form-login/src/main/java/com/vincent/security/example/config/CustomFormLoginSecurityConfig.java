package com.vincent.security.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

        // 使用表单登录，并告诉 Spring Security 授权请求的URL以及修改默认的字段名
        httpSecurity.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/customFormLogin")
                .usernameParameter("email")
                .and()

                // 首页和登录页面，未授权的用户也可以访问
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
