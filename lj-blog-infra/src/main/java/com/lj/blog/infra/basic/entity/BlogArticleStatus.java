package com.lj.blog.infra.basic.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章统计表(BlogArticleStatus)实体类
 *
 * @author makejava
 * @since 2024-12-19 13:29:28
 */
public class BlogArticleStatus implements Serializable {
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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getCollections() {
        return collections;
    }

    public void setCollections(Integer collections) {
        this.collections = collections;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

