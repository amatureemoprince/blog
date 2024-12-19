package com.lj.blog.infra.basic.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 博客主页展示信息表(BlogContentItems)实体类
 *
 * @author makejava
 * @since 2024-12-18 18:49:39
 */
@Builder
@Data
public class BlogContentItems implements Serializable {
    @Serial
    private static final long serialVersionUID = -44335975530209762L;
    /**
     * 自增主键，唯一标识每条记录
     */
    private Integer id;
    /**
     * 内容类型，0代表句子，1代表标题，2代表页脚
     */
    private Integer type;
    /**
     * 存储实际的内容
     */
    private String content;
    /**
     * 存储实际的记录的创建时间内容
     */
    private Date createTime;
    /**
     * 记录的更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除0未删除
     * */
    private Integer isDeleted;
}

