package com.lj.blog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName RedisEnum
 * @Description redis中的key值
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/31 14:38
 * @Version JDK 17
 */
@AllArgsConstructor
@Getter
public enum RedisEnum {
    //后接着文章id，value为文章数据
    ARTICLE_INFO("article:info:"),
    //后接着文章id，value为点赞数
    ARTICLE_LIKE("article:like:");
    private final String key;
}
