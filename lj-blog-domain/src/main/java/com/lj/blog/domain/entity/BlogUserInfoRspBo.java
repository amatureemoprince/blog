package com.lj.blog.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName BlogUserInfoRspBo
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/22 9:59
 * @Version JDK 17
 */
@Data
public class BlogUserInfoRspBo {
    private String nickName;
    private String email;
    private String password;
    private Integer sex;
    private Date createTime;
}
