package com.lj.blog.application.controller.dto.article.info;

import lombok.Data;

/**
 * @ClassName AddArticleInfoDto
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 13:19
 * @Version JDK 17
 */
@Data
public class AddArticleInfoDto {
    private String articleTitle;
    private String articleDesc;
    private int articleTop;
    private String coverImage;
    private int articleStatus;
}
