package com.lj.blog.application.controller.dto.article.category;

import lombok.Data;

/**
 * @ClassName UpdateArticleCategoryDto
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/11 18:00
 * @Version JDK 17
 */
@Data
public class UpdateArticleCategoryDto {
    private Integer id;
    private String categoryName;
    private Integer parentId;
    private String categoryDesc;
    private String imageUrl;
    private Integer sortOrder;
}
