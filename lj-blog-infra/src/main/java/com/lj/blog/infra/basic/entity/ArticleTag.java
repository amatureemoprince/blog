package com.lj.blog.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章标签表(ArticleTag)实体类
 *
 * @author makejava
 * @since 2024-12-12 08:17:38
 */
@Data
@TableName("article_tag")
public class ArticleTag implements Serializable {
    private static final long serialVersionUID = 938819096082714138L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String tagName;

    private String tagDesc;

    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;

}

