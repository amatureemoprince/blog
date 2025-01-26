package com.lj.blog.infra.basic.entity;

import lombok.Data;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 角色权限表(BlogRolePermission)实体类
 *
 * @author makejava
 * @since 2025-01-26 15:17:16
 */
@Data
public class BlogRolePermission implements Serializable {

    @Serial
    private static final long serialVersionUID = 760661346428182026L;
    /**
     * 角色权限ID
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 权限名称
     */
    private String permission;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否删除（0: 否, 1: 是）
     */
    private Integer isDeleted;


}

