package com.lj.blog.infra.basic.entity;

import lombok.Data;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 博客角色表(BlogRole)实体类
 *
 * @author makejava
 * @since 2025-01-26 18:17:10
 */
@Data
public class BlogRole implements Serializable {
    @Serial
    private static final long serialVersionUID = -87594751877504655L;
    /**
     * 角色ID
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否删除（0: 否, 1: 是）
     */
    private Integer isDeleted;


}

