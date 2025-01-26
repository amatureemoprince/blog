package com.lj.blog.infra.basic.entity;

import lombok.Data;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 博客权限表(BlogPermission)实体类
 *
 * @author makejava
 * @since 2025-01-26 18:22:12
 */
@Data
public class BlogPermission implements Serializable {
    @Serial
    private static final long serialVersionUID = 704077707591918405L;
    /**
     * 权限ID
     */
    private Integer id;
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

