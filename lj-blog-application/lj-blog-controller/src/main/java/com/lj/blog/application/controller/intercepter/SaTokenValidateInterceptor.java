package com.lj.blog.application.controller.intercepter;

import cn.dev33.satoken.interceptor.SaInterceptor;
import com.lj.blog.common.satoken.StpKit;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName SaTokenValidateInterceptor
 * @Description SaToken校验拦截器：拦截用户需要访问的接口
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/18 15:41
 * @Version JDK 17
 */
@Configuration
public class SaTokenValidateInterceptor implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handler -> StpKit.USER.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns("/home/**",
                        "/test/**",
                        "/email/**",
                        "/user/login",
                        "/user/register",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/doc.html",
                        "/webjars/**",
                        "/favicon.ico",
                        "/v3/**")
                .order(10);
        registry.addInterceptor(new SaInterceptor(handle -> StpKit.ADMIN.checkLogin()))
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
                .order(10);
    }
}
