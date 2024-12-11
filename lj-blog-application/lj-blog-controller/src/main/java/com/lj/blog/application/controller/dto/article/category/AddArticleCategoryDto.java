package com.lj.blog.application.controller.dto.article.category;
import lombok.Data;


/**
 * @ClassName AddArticleCategoryDto
 * @Description 文章标签dto
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 9:04
 * @Version JDK 17
 */
@Data
public class AddArticleCategoryDto {
    private String categoryName;
    private Integer parentId;
    private String categoryDesc;
    private String imageUrl;
    private Integer sortOrder;
}
