package com.lj.blog.application.controller.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.lj.blog.application.controller.exception.exceptions.BusinessException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * @ClassName GlobalException
 * @Description 全局异常捕获
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/17 22:49
 * @Version JDK 17
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> businessExceptionHandler(BusinessException e) {
        log.error("BUSINESS ERROR: {} {}", e, e.getMessage());
        return ResponseEntity.<String>builder()
                .code(e.getCode())
                .message(e.getMessage())
                .data(null)
                .build();
    }

    @ExceptionHandler(NotLoginException.class)
    public ResponseEntity<?> notLoginExceptionHandler(NotLoginException e){
        String message = switch (e.getType()) {
            case NotLoginException.INVALID_TOKEN -> "你的登录无效";
            case NotLoginException.TOKEN_TIMEOUT -> "你的登录已过期";
            case NotLoginException.BE_REPLACED -> "你被顶号了";
            case NotLoginException.KICK_OUT -> "你已经被踢下了";
            default -> "请进行登录";
        };
        log.error("SaToken ERROR: {} {}", e, e.getMessage());
        return ResponseEntity.builder()
                .code(400)
                .message(message)
                .data(null)
                .build();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> httpRequestMethodNotSupport(HttpRequestMethodNotSupportedException e){
        return ResponseEntity.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message("没有该api接口")
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exception(Exception e){
        log.error("SYSTEM ERROR: {} {}", e, e.getMessage());
        return ResponseEntity.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("系统错误")
                .build();
    }
    @Data
    @Builder
    public static class ResponseEntity<T>{
        private int code;
        private String message;
        private T data;
    }
}
