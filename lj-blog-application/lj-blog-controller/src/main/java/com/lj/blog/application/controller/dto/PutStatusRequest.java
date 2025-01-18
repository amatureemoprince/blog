package com.lj.blog.application.controller.dto;

import lombok.Data;

/**
 * @ClassName PutStatusRequest
 * @Description 点赞、收藏、评论文章的请求dto。用于数据量的加一
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/28 14:57
 * @Version JDK 17
 */
@Data
public class PutStatusRequest {
    private Integer articleId;
    private Integer tag;
}
