package com.lj.blog.application.controller.dto.article.tag;

import lombok.Data;

/**
 * @ClassName UpdateArticleTagDto
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/13 8:51
 * @Version JDK 17
 */
@Data
public class UpdateArticleTagDto {
    private Integer id;
    private String tagName;
    private String tagDesc;
}
