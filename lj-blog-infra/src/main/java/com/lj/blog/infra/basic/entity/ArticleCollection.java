package com.lj.blog.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户收藏表(ArticleCollection)实体类
 *
 * @author makejava
 * @since 2024-12-12 08:33:25
 */
@Data
@TableName("article_collection")
public class ArticleCollection implements Serializable {
    private static final long serialVersionUID = -42608640293309255L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer articleId;

    private Integer userId;

    private Date createTime;

    private Integer isDeleted;

}

