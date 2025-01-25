package com.lj.blog.infra.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(BlogUser)实体类
 *
 * @author makejava
 * @since 2025-01-20 14:11:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 183748108208100883L;
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户性别 (0: 未知, 1: 男, 2: 女)
     */
    private Integer sex;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 用户密码
     * */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除 (0: 否, 1: 是)
     */
    private Integer isDeleted;

    /**
     * 用户头像
     */
    private String avatar;



}

