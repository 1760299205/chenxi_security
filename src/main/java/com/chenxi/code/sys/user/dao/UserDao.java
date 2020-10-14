package com.chenxi.code.sys.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenxi.code.sys.role.entity.RoleEntity;
import com.chenxi.code.sys.user.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseMapper<UserEntity> {
    @Select("select * from  role r, user_role ur where  r.id = ur.role_id and  ur.user_id = #{id}")
    public List<RoleEntity> getUserRolesByUid(@Param("id") Integer id);
}
