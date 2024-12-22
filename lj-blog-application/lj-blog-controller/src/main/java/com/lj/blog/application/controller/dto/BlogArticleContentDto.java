package com.lj.blog.application.controller.dto;
import lombok.Data;

/**
 * @ClassName BlogArticleContentDto
 * @Description 文章详细内容
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/20 17:04
 * @Version JDK 17
 */
@Data
public class BlogArticleContentDto {
    //markdown格式数据
    private String articleContent;
}
