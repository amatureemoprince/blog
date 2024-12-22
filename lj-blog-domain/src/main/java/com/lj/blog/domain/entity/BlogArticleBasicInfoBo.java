package com.lj.blog.domain.entity;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName BlogArticleBasicInfoBo
 * @Description 文章展示的基本信息
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/19 17:12
 * @Version JDK 17
 */
@Data
public class BlogArticleBasicInfoBo {
    /**
     * 文章主键
     * */
    private Integer id;

    /**
     * 文章标题
     * * */
    private String title;

    /**
     * 文章概要
     * */
    private String description;

    /**
     * 文章封面
     * */
    private String coverImage;

    /**
     * 文章创建时间
     * */
    private Date createTime;

    /**
     * 文章建议阅读时间
     * */
    private Integer readingTime;

    /**
     * 文章分类
     * */
    private String category;

    /**
     * 文章标签
     * */
    private List<String> labels;

    /**
     * 文章点赞数
     * */
    private Integer likes;

    /**
     * 文章浏览数
     * */
    private Integer views;

    /**
     * 文章评论数
     * */
    private Integer comments;

    /**
     * 文章收藏数
     * */
    private Integer collections;
}
