package com.chenxi.code.sys.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Data
public  class RoleEntity implements Serializable  {
        private static final long serialVersionUID = 825384782616737527L;

        private Integer id;

        private String name;

        private String description;

}
