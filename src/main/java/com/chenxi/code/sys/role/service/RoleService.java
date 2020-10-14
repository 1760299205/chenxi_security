package com.chenxi.code.sys.role.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chenxi.code.sys.login.dao.loginDao;
import com.chenxi.code.sys.login.entity.loginEntity;
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

import java.sql.Wrapper;
import java.util.List;

@Service
public class RoleService  {

}
