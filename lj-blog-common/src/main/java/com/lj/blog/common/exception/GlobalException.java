package com.lj.blog.common.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import com.lj.blog.common.exception.exceptions.BusinessException;
import com.lj.blog.common.utils.LogUtils;
import jakarta.mail.SendFailedException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailSendException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.UnsupportedEncodingException;

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
        log.error(LogUtils.red("SaToken ERROR: " + e + " " + e.getMessage()));
        return ResponseEntity.builder()
                .code(400)
                .message(message)
                .data(null)
                .build();
    }

    @ExceptionHandler(NotPermissionException.class)
    public ResponseEntity<?> notPermissionException(NotPermissionException e){
        log.error(LogUtils.red("SaToken ERROR: " + e + " " + e.getMessage()));
        return ResponseEntity.builder()
                .code(HttpStatus.FORBIDDEN.value())
                .message("没有权限")
                .data(null)
                .build();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> httpRequestMethodNotSupport(HttpRequestMethodNotSupportedException e){
        log.error(LogUtils.red("系统没有该接口 " + e + " " + e.getMessage()));
        return ResponseEntity.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message("没有该api接口")
                .build();
    }

    @ExceptionHandler(SendFailedException.class)
    public ResponseEntity<?> sendFailedException(SendFailedException e){
        log.error(LogUtils.red("EMAIL-ERROR: " + e + " " + e.getMessage()));
        return ResponseEntity.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("发送邮箱失败")
                .data(null).build();
    }

    @ExceptionHandler(MailSendException.class)
    public ResponseEntity<?> mailSendException(MailSendException e){
        log.error(LogUtils.red("EMAIL-ERROR: " + e + " " + e.getMessage()));
        return ResponseEntity.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("发送邮箱失败")
                .data(null).build();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exception(Exception e){
        log.error(LogUtils.red("SYSTEM-ERROR: 系统错误, 错误信息: " + e + " " + e.getMessage()));
        return ResponseEntity.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("系统错误")
                .build();
    }

    @ExceptionHandler(UnsupportedEncodingException.class)
    public void handleUnsupportedEncodingException(UnsupportedEncodingException e) {
        log.error(LogUtils.red("SYSTEM-ERROR: 编码不支持, 错误信息: " + e.getMessage() + e));
    }

    @Data
    @Builder
    public static class ResponseEntity<T>{
        private int code;
        private String message;
        private T data;
    }
}
