package com.lj.blog.application.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName BlogUserInfoRspDto
 * @Description 返回给前端的个人信息
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/21 23:05
 * @Version JDK 17
 */
@Schema(title = "返回用户信息模型")
@Data
public class BlogUserInfoRspDto {
    private String nickName;
    private String email;
    private String password;
    private Integer sex;
    private Date createTime;
}
