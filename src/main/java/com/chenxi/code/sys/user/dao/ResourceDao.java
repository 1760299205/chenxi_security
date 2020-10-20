package com.chenxi.code.sys.user.dao;

import com.chenxi.code.sys.user.entity.ResourcesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ResourceDao {
    /**
     * @Author dw
     * @Description 获取所有的资源
     * @Date 2020/4/15 11:16
     * @Param
     * @return
     */
    @Select(" SELECT\n" +
            "         r.*,\n" +
            "         re.id AS roleId,\n" +
            "         re.`name`,\n" +
            "         re.description\n" +
            "        FROM resources AS r\n" +
            "        LEFT JOIN role_resource AS rr  ON r.id = rr.resource_id\n" +
            "        LEFT JOIN role AS re ON re.id = rr.role_id")
    public List<ResourcesEntity> getAllResources();
}
