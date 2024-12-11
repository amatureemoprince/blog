package com.lj.blog.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.io.Serializable;

/**
 * 文章信息表(ArticleInfo)实体类
 *
 * @author makejava
 * @since 2024-12-10 10:34:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("article_info")
public class ArticleInfo implements Serializable {

    private static final long serialVersionUID = -36256161751444334L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String articleTitle;

    private String articleDesc;

    private Integer articleTop;

    private String coverImage;

    private Integer articleStatus;

    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;

}

