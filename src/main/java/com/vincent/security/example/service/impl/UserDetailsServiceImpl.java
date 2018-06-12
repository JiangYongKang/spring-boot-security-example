package com.vincent.security.example.service.impl;

import com.vincent.security.example.mapper.RoleMapper;
import com.vincent.security.example.mapper.UserMapper;
import com.vincent.security.example.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: vincent
 * Date: 2018-06-12 16:49:00
 * Comment: 这个接口只定义了一个方法 loadUserByUsername，顾名思义，就是提供一种从用户名可以查到用户并返回的方法。
 * 注意，不一定是数据库，文本文件、xml文件等等都可能成为数据源，这也是为什么 Spring 提供这样一个接口的原因：保证你可以采用灵活的数据源。
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Cannot find user with username, username = " + username);
        user.setRoles(roleMapper.selectByUserId(user.getId()));
        return user;
    }
}
