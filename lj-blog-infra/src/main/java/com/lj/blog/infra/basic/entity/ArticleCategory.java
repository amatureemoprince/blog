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
 * 文章分类表(ArticleCategory)实体类
 *
 * @author makejava
 * @since 2024-12-10 17:44:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("article_category")
public class ArticleCategory implements Serializable {
    private static final long serialVersionUID = -83015056857151107L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String categoryName;

    private Integer parentId;

    private Integer level;

    private String categoryDesc;

    private String imageUrl;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;


}

