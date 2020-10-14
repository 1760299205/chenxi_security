package com.chenxi.code.sys.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.RoleResult;
import java.util.ArrayList;
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

    @TableField(exist = false)
    private List<RoleEntity> userRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
