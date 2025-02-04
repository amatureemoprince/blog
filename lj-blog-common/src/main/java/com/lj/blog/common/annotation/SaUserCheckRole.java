package com.lj.blog.common.annotation;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.lj.blog.common.satoken.StpKit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 判断用户角色
 * @author lj
 */
@SaCheckRole(type = StpKit.USER_ROLE)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE})
public @interface SaUserCheckRole {
}
