package com.lj.blog.application.controller.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @ClassName BlogArticleContentDto
 * @Description 文章详细内容
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/20 17:04
 * @Version JDK 17
 */
@Schema(title = "文章内容模型")
@Data
public class BlogArticleContentDto {
    //markdown格式数据
    private String articleContent;
}
