package com.vincent.security.example.config;

import com.vincent.security.example.filter.AuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Author: vincent
 * Date: 2018-06-12 17:02:00
 * Comment:
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 因为我们实现了 UserDetailsService，Spring 会自动在项目中查找它的实现类，
     * 这里注入的也自然是我们自定义的 UserDetailsServiceImpl 类
     */
    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private AuthenticationTokenFilter authenticationTokenFilter;

    /**
     * 设置我们自己实现的的 UserDetailsService，并设置密码的加密方式，加密方式不是必须的，也就是说，这里是可以明文密码
     * @param authenticationManagerBuilder
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 因为我们是基于 token 进行验证的，所以 csrf 和 session 我们这里都不需要
        httpSecurity.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()

                // 获取 token 的接口所有人都可以访问
                .antMatchers("/authentication/**").permitAll()

                // 除了上面的接口，其它接口都必须鉴权认证
                .anyRequest().authenticated();
        httpSecurity.headers().cacheControl();

        // 将我们实现的过滤器添加进去，方法名可以很轻松的看出来是前置过滤
        httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
