package com.lj.blog.infra.basic.entity;

import lombok.Data;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 博客分类表(BlogCategory)实体类
 *
 * @author makejava
 * @since 2024-12-19 13:29:47
 */
@Data
public class BlogCategory implements Serializable {
    @Serial
    private static final long serialVersionUID = -46273595070412219L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String category;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除标志，0表示未删除，1表示已删除
     */
    private Integer isDeleted;



}

