package com.lj.blog.application.controller.exception.exceptions;

import lombok.Getter;

/**
 * @ClassName BusinessException
 * @Description 自定义业务异常类，用于处理业务逻辑异常
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/17 22:51
 * @Version JDK 17
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    /**
     * 仅传入错误信息，使用默认错误码
     * @param message 错误信息
     */
    public BusinessException(String message) {
        this(500, message);
    }

    /**
     * 传入错误码和错误信息
     * @param code 错误码
     * @param message 错误信息
     */
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 传入错误信息和异常
     * @param message 错误信息
     * @param cause 异常
     */
    public BusinessException(String message, Throwable cause) {
        this(500, message, cause);
    }

    /**
     * 传入错误码、错误信息和异常
     * @param code 错误码
     * @param message 错误信息
     * @param cause 异常
     */
    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
