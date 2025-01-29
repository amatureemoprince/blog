package com.lj.blog.common.constant;

import lombok.Getter;

/**
 * @ClassName PermissionConstant
 * @Description 用户权限常量类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/18 20:23
 * @Version JDK 17
 */
@Getter
public class PermissionConstant {
    //普通用户对文章的权限
    public static final String USER_ARTICLE_LIKE = "user:article:like";
    public static final String USER_ARTICLE_SELECT = "user:article:select";
    public static final String USER_ARTICLE_COLLECTION = "user:article:collection";
    //普通用户对评论的权限
    public static final String USER_COMMENT_PUT = "user:comment:put";
    public static final String USER_COMMENT_DELETE = "user:comment:delete";
    public static final String USER_COMMENT_SELECT = "user:comment:select";
    //vip用户权限
    public static final String VIP_ARTICLE_ALL = "vip:article:*";

}
