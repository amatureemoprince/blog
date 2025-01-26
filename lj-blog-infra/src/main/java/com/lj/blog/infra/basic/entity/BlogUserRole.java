package com.lj.blog.infra.basic.entity;

import lombok.Data;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 用户角色表(BlogUserRole)实体类
 *
 * @author makejava
 * @since 2025-01-26 15:15:24
 */
@Data
public class BlogUserRole implements Serializable {
    @Serial
    private static final long serialVersionUID = 199046599382944302L;
    /**
     * 用户角色ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户角色名称
     */
    private String userRoleName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否删除（0: 否, 1: 是）
     */
    private Integer isDeleted;


}

