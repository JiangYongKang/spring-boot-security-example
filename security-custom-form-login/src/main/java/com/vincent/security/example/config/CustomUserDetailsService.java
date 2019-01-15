package com.vincent.security.example.config;

import com.vincent.security.example.execption.EmailNotFoundException;
import com.vincent.security.example.model.MemberEntity;
import com.vincent.security.example.repository.MemberRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author: vincent
 * DateTime: 2019/1/15 22:14
 * Comment:
 */

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private MemberRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MemberEntity memberEntity = repository.findByEmail(email);
        if (memberEntity == null) throw new EmailNotFoundException("错误的邮箱：" + email);
        return new User(memberEntity.getEmail(), memberEntity.getPassword(), AuthorityUtils.NO_AUTHORITIES);
    }
}
