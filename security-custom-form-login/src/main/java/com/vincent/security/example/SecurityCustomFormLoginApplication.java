package com.vincent.security.example;

import com.vincent.security.example.model.MemberEntity;
import com.vincent.security.example.repository.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Author: vincent
 * DateTime: 2019/1/15 21:18
 * Comment:
 */

@SpringBootApplication
public class SecurityCustomFormLoginApplication {

    @Resource
    private MemberRepository repository;

    @Resource
    private PasswordEncoder encoder;

    @PostConstruct
    public void initDatabase() {
        repository.save(
                new MemberEntity(1, "example@mail.com", encoder.encode("123456"), 0)
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityCustomFormLoginApplication.class, args);
    }

}
