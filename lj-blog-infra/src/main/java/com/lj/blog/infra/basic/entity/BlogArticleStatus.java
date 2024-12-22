package com.lj.blog.infra.basic.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 文章统计表(BlogArticleStatus)实体类
 *
 * @author makejava
 * @since 2024-12-19 13:29:28
 */
@Data
@Builder
public class BlogArticleStatus implements Serializable {
    @Serial
    private static final long serialVersionUID = 351389305771926142L;
    /**
     * 文章统计主键
     */
    private Integer id;
    /**
     * 文章id
     */
    private Integer articleId;
    /**
     * 文章浏览数量
     */
    private Integer views;
    /**
     * 文章点赞数量
     */
    private Integer likes;
    /**
     * 文章评论数量
     */
    private Integer comments;
    /**
     * 文章收藏数量
     */
    private Integer collections;
    /**
     * 文章统计变化时间
     */
    private Date updateTime;




}

