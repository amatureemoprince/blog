package com.lj.blog.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 文章标签关联表(ArticleTagRel)实体类
 *
 * @author makejava
 * @since 2024-12-12 09:16:30
 */
@Data
@TableName("article_tag_rel")
public class ArticleTagRel implements Serializable {
    private static final long serialVersionUID = 396410384541735550L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer articleId;

    private Integer tagId;

    private Date createTime;

    private Integer isDeleted;

}

