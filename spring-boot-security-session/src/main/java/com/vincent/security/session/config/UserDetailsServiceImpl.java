package com.vincent.security.session.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: vincent
 * Date: 2019-01-12 17:01:00
 * Comment:
 */

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String password = passwordEncoder.encode("123456");
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("default, admin");
        User user = new User(s, password, authorities);
        System.out.println(user.toString());
        return user;
    }
}
