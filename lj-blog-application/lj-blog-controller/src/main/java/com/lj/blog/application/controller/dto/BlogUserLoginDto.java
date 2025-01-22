package com.lj.blog.application.controller.dto;

import lombok.Data;

/**
 * @ClassName BlogUserLoginDto
 * @Description 这个userName可以是用户名或者注册邮箱
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/21 19:02
 * @Version JDK 17
 */
@Data
public class BlogUserLoginDto {
    private String userName;
    private String password;
}
