package com.lj.blog.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户点赞表(ArticleLike)实体类
 *
 * @author makejava
 * @since 2024-12-12 09:03:34
 */
@Data
@TableName("article_like")
public class ArticleLike implements Serializable {
    private static final long serialVersionUID = 394588787904851100L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer articleId;

    private Integer userId;

    private Date createTime;

    private Integer isDeleted;

}

