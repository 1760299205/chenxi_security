package com.chenxi.code.sys.role.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenxi.code.sys.login.entity.loginEntity;
import com.chenxi.code.sys.role.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface RoleDao extends BaseMapper<RoleEntity> {

}
