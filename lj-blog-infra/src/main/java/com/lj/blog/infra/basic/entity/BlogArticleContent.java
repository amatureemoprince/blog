package com.lj.blog.infra.basic.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 文章内容表(BlogArticleContent)实体类
 *
 * @author makejava
 * @since 2024-12-19 13:29:00
 */
@Builder
@Data
public class BlogArticleContent implements Serializable {
    @Serial
    private static final long serialVersionUID = 918234898718199213L;
    /**
     * 文章内容主键
     */
    private Integer id;
    /**
     * 文章id
     */
    private Integer articleId;
    /**
     * 文章内容
     */
    private String articleContent;
    /**
     * 文章内容的html格式
     */
    private String articleHtml;
    /**
     * 文章内容创建时间
     */
    private Date createTime;
    /**
     * 文章内容更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除标志，0表示未删除，1表示已删除
     */
    private Integer isDeleted;



}

