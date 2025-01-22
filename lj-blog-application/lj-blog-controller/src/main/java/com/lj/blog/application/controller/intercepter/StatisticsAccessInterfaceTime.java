package com.lj.blog.application.controller.intercepter;

import com.lj.blog.common.utils.LogUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName StatisticsAccessInterfaceTime
 * @Description 获取接口运行时间
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/17 21:16
 * @Version JDK 17
 */
@RestControllerAdvice
@Slf4j
public class StatisticsAccessInterfaceTime implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(@NonNull MethodParameter returnType, @NonNull Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, @NonNull MethodParameter returnType, @NonNull MediaType selectedContentType, @NonNull Class selectedConverterType, @NonNull ServerHttpRequest request, @NonNull ServerHttpResponse response) {
        HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
        Object startTimeObj = servletRequest.getAttribute("startTime");
        if (startTimeObj instanceof Long) {
            long startTime = (Long) startTimeObj;
            long time = System.currentTimeMillis() - startTime;
            if(time < 1000){
                log.info("{}", LogUtil.blue(">>> 执行了："+ time +"毫秒"));
                return body;
            }
            log.warn(LogUtil.yellow("执行时间过长：" + time + "毫秒"));
        } else {
            log.warn(LogUtil.yellow("没有到获取时间的拦截器"));
        }
        return body;
    }

}

