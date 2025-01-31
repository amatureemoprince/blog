package com.lj.blog.common.annotation;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.lj.blog.common.satoken.StpKit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lj
 * @Description 检测用户是否登录
 */
@SaCheckLogin(type = StpKit.USER_ROLE)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE})
public @interface SaUserCheckLogin {
}
