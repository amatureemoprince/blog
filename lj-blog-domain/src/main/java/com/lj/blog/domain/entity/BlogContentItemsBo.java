package com.lj.blog.domain.entity;

import lombok.Data;


/**
 * @ClassName BlogContentItemsBo
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/18 19:00
 * @Version JDK 17
 */
@Data
public class BlogContentItemsBo {
    /**
     * 内容类型，0代表句子，1代表标题，2代表页脚
     */
    private Integer type;
    /**
     * 存储实际的内容
     */
    private String content;
}
