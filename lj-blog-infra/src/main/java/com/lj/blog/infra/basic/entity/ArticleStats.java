package com.lj.blog.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章统计表(ArticleStats)实体类
 *
 * @author makejava
 * @since 2024-12-12 09:08:01
 */
@Data
@TableName("article_stats")
public class ArticleStats implements Serializable {
    private static final long serialVersionUID = 685094197360859108L;
    @TableId(type = IdType.AUTO)
    private Integer articleId;

    private Integer viewCount;

    private Integer likeCount;

    private Integer commentCount;

    private Integer collectionCount;

    private Integer shareCount;

    private Date updateTime;

}

