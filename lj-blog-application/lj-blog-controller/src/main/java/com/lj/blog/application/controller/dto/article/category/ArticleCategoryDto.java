package com.lj.blog.application.controller.dto.article.category;

import lombok.Data;

/**
 * @ClassName ArticleCategoryDto
 * @Description 返回给前端的数据格式
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/11 16:59
 * @Version JDK 17
 */
@Data
public class ArticleCategoryDto {
    private Integer id;
    private String categoryName;
    private Integer parentId;
    private Integer level;
    private String categoryDesc;
    private String imageUrl;
}
