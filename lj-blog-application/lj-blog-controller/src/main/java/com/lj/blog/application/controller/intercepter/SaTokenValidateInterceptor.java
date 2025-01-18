package com.lj.blog.application.controller.intercepter;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName SaTokenValidateInterceptor
 * @Description 校验拦截器
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/18 15:41
 * @Version JDK 17
 */
@Configuration
public class SaTokenValidateInterceptor implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handler -> StpUtil.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns("/home/articles",
                        "/home/get/**",
                        "/home/sentences",
                        "/login",
                        "/register")
                .order(10);
    }
}
