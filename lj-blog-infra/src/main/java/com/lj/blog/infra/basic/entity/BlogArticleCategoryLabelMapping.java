package com.lj.blog.infra.basic.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章分类标签关系表(BlogArticleCategoryLabelMapping)实体类
 *
 * @author makejava
 * @since 2024-12-19 13:28:39
 */
public class BlogArticleCategoryLabelMapping implements Serializable {
    private static final long serialVersionUID = 212091637836247255L;
/**
     * 文章分类标签关系主键
     */
    private Integer id;
/**
     * 文章id
     */
    private Integer articleId;
/**
     * 分类id
     */
    private Integer categoryId;
/**
     * 标签id
     */
    private Integer labelId;
/**
     * 文章标签创建时间
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

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
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

