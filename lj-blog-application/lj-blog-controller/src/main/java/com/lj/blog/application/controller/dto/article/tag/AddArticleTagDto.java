package com.lj.blog.application.controller.dto.article.tag;

import lombok.Data;

/**
 * @ClassName AddArticleTagDto
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/12 9:26
 * @Version JDK 17
 */
@Data
public class AddArticleTagDto {
    private String tagName;
    private String tagDesc;
}
