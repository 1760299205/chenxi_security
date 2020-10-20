package com.chenxi.code.sys.user.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chenxi.code.sys.user.dao.UserDao;
import com.chenxi.code.sys.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService  implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    /*
    *自定义验证后续
    *name:xurenxin
    *time:2020/10/16 16:37
    */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //实现 UserDetailsService 这个类下面的 loadUserByUsername方法（前台输入的用户名），两个参数
        LambdaQueryWrapper<UserEntity> userWrapper = new LambdaQueryWrapper<>();
        userWrapper.eq(UserEntity::getUsername,username);
        //查询用户是否存在
        UserEntity user =userDao.selectOne(userWrapper);
        if (null != user){
            //获取用户权限 和 菜单
            user.setUserRoles(userDao.getUserRolesByUid(user.getId()));
            return user;
        }else{
            throw  new UsernameNotFoundException("账号不存在！");
        }

    }
}
