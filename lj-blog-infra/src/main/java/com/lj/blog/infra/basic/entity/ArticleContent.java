package com.lj.blog.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章内容表(ArticleContent)实体类
 *
 * @author makejava
 * @since 2024-12-12 08:12:55
 */
@Data
@TableName("article_content")
public class ArticleContent implements Serializable {
    private static final long serialVersionUID = 245938463809708981L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer articleId;

    private String articleContent;

    private String articleHtml;

    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;

}

