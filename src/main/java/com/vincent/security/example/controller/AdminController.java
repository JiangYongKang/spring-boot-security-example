package com.vincent.security.example.controller;

import com.vincent.security.example.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: vincent
 * Date: 2018-06-12 20:13:00
 * Comment:
 * 在 @PreAuthorize 注解中可以利用内置的表达式，比如: hasRole('ADMIN') 来决定哪些用户有权限访问
 * 需要注意的 hasRole 表达式默认的前缀为 'ROLE_' 也就是说，这里的 hasRole('ADMIN') 对应数据库的是 'ROLE_ADMIN'
 */

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Resource
    private UserMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> index(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(mapper.findById(id));
    }
}
