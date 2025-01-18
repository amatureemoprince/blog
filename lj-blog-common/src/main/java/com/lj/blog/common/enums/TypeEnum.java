package com.lj.blog.common.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName TypeEnum
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/19 20:41
 * @Version JDK 17
 */
@AllArgsConstructor
@Getter
public enum TypeEnum {
    LIKE(1, "点赞量"),
    VIEW(2, "浏览量"),
    COMMENT(3, "评论量"),
    COLLECTION(4, "收藏量"),
    IS_DELETED(5, "删除"),
    IS_NOT_DELETED(0, "未删除");
    final int code;
    final String msg;
}
