package com.chenxi.code.sys.user.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenxi.code.sys.role.dao.RoleDao;
import com.chenxi.code.sys.role.entity.RoleEntity;
import com.chenxi.code.sys.user.dao.UserDao;
import com.chenxi.code.sys.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserDao userDao;




    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<UserEntity> userWrapper = new LambdaQueryWrapper<>();
        userWrapper.eq(UserEntity::getUsername,username);
        UserEntity user =userDao.selectOne(userWrapper);
        if (null == user){
            throw  new UsernameNotFoundException("账号不存在！");
        }
//        String encodePassword = passwordEncoder.encode(user.getPassword());
//        System.out.println("加密后的密码：" + encodePassword);
//        user.setPassword(encodePassword);
//        user.setUserRoles(userDao.getUserRolesByUid(user.getId()));
        return user;
    }
}
