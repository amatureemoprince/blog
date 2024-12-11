package com.lj.blog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * @ClassName ArticleModuleEnum
 * @Description 同一响应返回信息
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 8:30
 * @Version JDK 17
 */
@AllArgsConstructor
@Getter
public enum ArticleModuleEnum {
    //成功的
    ADD_CATEGORY_SUCCESS(206, "新增文章分类成功"),
    ADD_CATEGORY_REL_SUCCESS(207, "添加文章分类关系成功"),

    ADD_ARTICLE_INFO_SUCCESS(200, "新增文章基本信息成功"),
    ADD_ARTICLE_CONTENT_SUCCESS(201, "新增文章内容成功"),
    DELETE_ARTICLE_CATEGORY_SUCCESS(202, "删除文章分类成功"),
    ADD_ARTICLE_LABEL_SUCCESS(203, "新增文章标签成功"),
    ADD_ARTICLE_LABEL_REL_SUCCESS(204, "添加文章标签关系成功"),
    SELECT_ARTICLE_CATEGORY_SUCCESS(205, "获取文章分类成功"),
    UPDATE_ARTICLE_CATEGORY_SUCCESS(206, "更新文章分类成功"),
    //失败的
    ADD_ARTICLE_LABEL_ERROR(400, "新增文章标签失败"),
    DELETE_ARTICLE_CATEGORY_ERROR(401, "删除文章分类失败"),
    SELECT_ARTICLE_CATEGORY_ERROR(403, "获取文章分类失败"),
    UPDATE_ARTICLE_CATEGORY_ERROR(404, "更新文章分类成功"),
    //规范
    ARTICLE_TITLE_NOT_NULL(100, "文章标题不能为空"),
    ARTICLE_DESC_NOT_NULL(101, "文章介绍不能为空"),

    ARTICLE_CATEGORY_EXIST(500, "文章分类已经存在"),

    ARTICLE_CATEGORY_TOP_SORT(1, "一级文章分类"),
    ARTICLE_CATEGORY_BOTTOM_SORT(2, "二级文章分类");


    public static ArticleModuleEnum getEnumByCode(int code){
        for (ArticleModuleEnum item : ArticleModuleEnum.values()) {
            if (item.code == code) {
                return item;
            }
        }
        return null;
    }
    public final int code;
    public final String msg;
}
