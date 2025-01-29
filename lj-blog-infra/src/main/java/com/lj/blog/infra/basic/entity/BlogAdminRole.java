package com.lj.blog.infra.basic.entity;

import lombok.Data;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 博客管理员角色表(BlogAdminRole)实体类
 *
 * @author makejava
 * @since 2025-01-26 18:28:14
 */
@Data
public class BlogAdminRole implements Serializable {
    @Serial
    private static final long serialVersionUID = 132826055646914756L;
    /**
     * 角色ID
     */
    private Integer id;

    private Integer adminId;
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

