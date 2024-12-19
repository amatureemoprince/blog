package com.lj.blog.infra.basic.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章内容表(BlogArticleContent)实体类
 *
 * @author makejava
 * @since 2024-12-19 13:29:00
 */
public class BlogArticleContent implements Serializable {
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleHtml() {
        return articleHtml;
    }

    public void setArticleHtml(String articleHtml) {
        this.articleHtml = articleHtml;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}

