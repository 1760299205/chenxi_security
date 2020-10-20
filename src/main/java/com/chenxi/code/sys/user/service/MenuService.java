package com.chenxi.code.sys.user.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chenxi.code.sys.user.dao.MenuDao;
import com.chenxi.code.sys.user.entity.MenuEntity;
import com.chenxi.code.sys.user.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;
    public List<MenuEntity> menuAll (){
        LambdaQueryWrapper<MenuEntity> wrapper = new LambdaQueryWrapper();
        return menuDao.selectList(wrapper);
    }
}
