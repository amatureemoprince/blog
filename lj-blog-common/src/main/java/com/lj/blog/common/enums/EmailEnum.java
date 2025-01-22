package com.lj.blog.common.enums;

import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName EmailEnum
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/20 16:04
 * @Version JDK 17
 */
@AllArgsConstructor
@Getter
public enum EmailEnum {
    EMAIL_HEAD("-止于春山 博客-"),
    CAPTCHA_SUBJECT("你的验证码到啦！！！"),
    CAPTCHA_CONTENT("请保管好你的验证码，请勿让他人知晓\n在3分钟内有效:\n\n\n");
    private final String msg;

}
