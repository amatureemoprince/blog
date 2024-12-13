package com.lj.blog.application.controller.dto.article.tag;

import lombok.Data;

/**
 * @ClassName ArticleTagDto
 * @Description 返回给前端的数据格式
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/12 11:19
 * @Version JDK 17
 */
@Data
public class ArticleTagDto {
    private Integer id;
    private String tagName;
    private String tagDesc;
}
