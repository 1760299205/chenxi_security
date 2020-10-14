package com.chenxi.code.sys.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chenxi.code.sys.role.entity.RoleEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@TableName(value = "user")
public class UserEntity implements UserDetails {

    private Integer id;

    private String userName;

    private String password;


    /*
     *激活状态，true：激活，false：锁定
     *name:xurenxin
     *time:2020/10/14 14:08
     */
    private boolean enable;


    /*
     *用户是否锁定(true:未锁定,false:锁定)
     *name:xurenxin
     *time:2020/10/14 14:05
     */
    private boolean locked;

    private List<RoleEntity> userRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
