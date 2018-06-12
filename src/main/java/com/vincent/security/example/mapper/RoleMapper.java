package com.vincent.security.example.mapper;

import com.vincent.security.example.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author: vincent
 * Date: 2018-06-12 17:00:00
 * Comment:
 */

@Mapper
public interface RoleMapper {
    @Select("select t1.id as id, t1.name as name from sys_role t1 left join sys_user_role t2 on t1.id = t2.sys_role_id where t2.sys_user_id = #{user_id}")
    List<Role> selectByUserId(@Param("user_id") Integer userId);
}
