package com.chenxi.code.sys.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("menu")
public class MenuEntity {
    private Long id;
    private String name;
    private String url;
    private String describe;
}
