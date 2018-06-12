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
 * Date: 2018-06-12 17:05:00
 * Comment:
 */

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('USER')")
public class UserController {

    @Resource
    private UserMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> index(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(mapper.findById(id));
    }
}
