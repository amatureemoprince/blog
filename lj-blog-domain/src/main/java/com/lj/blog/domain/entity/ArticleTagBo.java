package com.lj.blog.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName ArticleTagBo
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/12 18:36
 * @Version JDK 17
 */
@Data
public class ArticleTagBo {
    private Integer id;
    private String tagName;
    private String tagDesc;
}
