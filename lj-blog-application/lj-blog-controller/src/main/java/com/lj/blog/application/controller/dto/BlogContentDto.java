package com.lj.blog.application.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @ClassName BlogContentDto
 * @Description 返回的展示到主页的数据
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/18 18:55
 * @Version JDK 17
 */
@Schema(title = "博客主页展示数据模型")
@Data
public class BlogContentDto {
    private String title;
    private String subtitle;
    private List<String> sentences;
    private String footer;
}
