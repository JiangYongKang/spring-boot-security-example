package com.vincent.security.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: vincent
 * DateTime: 2019/1/15 22:14
 * Comment:
 */

@Data
@Entity
@Table(name = "members")
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

    @Id
    private Integer id;

    @Column(length = 64)
    private String email;

    @Column(length = 128)
    private String password;

    @Column
    private Integer status;

}
