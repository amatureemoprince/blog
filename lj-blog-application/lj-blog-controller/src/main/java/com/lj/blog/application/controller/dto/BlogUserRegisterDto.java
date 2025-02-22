package com.lj.blog.application.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @ClassName BlogUserRegisterDto
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/20 14:31
 * @Version JDK 17
 */
@Schema(title = "用户注册模型")
@Data
public class BlogUserRegisterDto {
    private String nickName;
    private String email;
    private String password;
    private Integer sex;
    private String captcha;
}
