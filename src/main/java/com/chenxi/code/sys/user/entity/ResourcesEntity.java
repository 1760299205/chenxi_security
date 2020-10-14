package com.chenxi.code.sys.user.entity;

import lombok.Data;

import java.util.List;

@Data
public class ResourcesEntity {
    private Integer id;

    private String pattern;

    private List<RoleEntity> roles;
}
