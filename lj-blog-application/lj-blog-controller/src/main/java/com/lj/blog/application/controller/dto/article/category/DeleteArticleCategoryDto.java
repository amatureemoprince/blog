package com.lj.blog.application.controller.dto.article.category;

import lombok.Data;

import java.util.List;

/**
 * @ClassName DeleteArticleCategoryDto
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/11 10:07
 * @Version JDK 17
 */
@Data
public class DeleteArticleCategoryDto {
    private List<Integer> ids;
}
