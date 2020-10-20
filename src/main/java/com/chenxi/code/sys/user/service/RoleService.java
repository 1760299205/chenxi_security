package com.chenxi.code.sys.user.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chenxi.code.sys.user.dao.RoleDao;
import com.chenxi.code.sys.user.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public List<RoleEntity> roleAll (){
        LambdaQueryWrapper<RoleEntity> wrapper = new LambdaQueryWrapper();
        return roleDao.selectList(wrapper);
    }
}
