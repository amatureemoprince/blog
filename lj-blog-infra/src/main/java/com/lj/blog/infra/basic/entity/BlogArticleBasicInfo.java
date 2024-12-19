package com.lj.blog.infra.basic.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章基本信息表(BlogArticleBasicInfo)实体类
 *
 * @author makejava
 * @since 2024-12-19 13:28:09
 */
public class BlogArticleBasicInfo implements Serializable {
    private static final long serialVersionUID = 939436274190981178L;
/**
     * 文章信息主键
     */
    private Integer id;
/**
     * 文章标题
     */
    private String title;
/**
     * 文章描述
     */
    private String description;
/**
     * 文章建议阅读时间（单位分钟）
     */
    private Integer readingTime;
/**
     * 文章封面图片
     */
    private String coverImage;
/**
     * 文章状态，0表示草稿，1表示已发布，2表示已删除等
     */
    private Integer articleStatus;
/**
     * 文章创建时间
     */
    private Date createTime;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(Integer readingTime) {
        this.readingTime = readingTime;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}

