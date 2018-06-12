package com.vincent.security.example.mapper;

import com.vincent.security.example.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Author: vincent
 * Date: 2018-06-12 16:57:00
 * Comment:
 */

@Mapper
public interface UserMapper {

    @Select("select * from sys_user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from sys_user where username = #{username}")
    User findByUsername(@Param("username") String username);

    @Insert("insert into sys_user(username, password, last_password_reset_date) values (#{username}, #{password}, #{lastPasswordResetDate})")
    Integer save(User user);
}
