package com.lj.blog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName ResultHttpEnum
 * @Description 返回类中的code，msg
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 8:39
 * @Version JDK 17
 */
@AllArgsConstructor
@Getter
public enum ResultHttpEnum {
    SUCCESS(200, "响应成功"),
    ERROR(400, "响应失败"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源未找到"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用");
    private final int httpCode;
    private final String msg;
}
