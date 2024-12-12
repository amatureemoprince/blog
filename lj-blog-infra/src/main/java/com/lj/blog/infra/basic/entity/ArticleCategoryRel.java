package com.lj.blog.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章分类关联表(ArticleCategoryRel)实体类
 *
 * @author makejava
 * @since 2024-12-12 08:26:18
 */
@Data
@TableName("article_category_rel")
public class ArticleCategoryRel implements Serializable {
    private static final long serialVersionUID = 455436316087600931L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer articleId;

    private Integer categoryId;

    private Date createTime;

    private Integer isDeleted;

}

