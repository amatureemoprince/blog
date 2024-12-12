package com.lj.blog.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章评论表(ArticleComment)实体类
 *
 * @author makejava
 * @since 2024-12-12 08:39:30
 */
@Data
@TableName("article_comment")
public class ArticleComment implements Serializable {
    private static final long serialVersionUID = 262359997476481748L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer articleId;

    private Integer userId;

    private String commentContent;

    private Integer parentId;

    private Integer replyUserId;

    private Integer rootId;

    private Integer likeCount;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;




}

