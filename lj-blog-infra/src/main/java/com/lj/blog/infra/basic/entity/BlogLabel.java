package com.lj.blog.infra.basic.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 博客标签表(BlogLabel)实体类
 *
 * @author makejava
 * @since 2024-12-19 13:30:09
 */
public class BlogLabel implements Serializable {
    private static final long serialVersionUID = -49207323392652352L;
/**
     * 文章标签主键
     */
    private Integer id;
/**
     * 文章标签名称
     */
    private String label;
/**
     * 文章标签创建时间
     */
    private Date createTime;
/**
     * 文章标签更新时间
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

