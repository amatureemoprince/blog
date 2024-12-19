package com.lj.blog.application.controller.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName CorsConfig
 * @Description 允许跨域访问
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/15 12:43
 * @Version JDK 17
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 指定允许的前端域名
                .allowedOrigins("http://localhost:5173")
                // 允许的HTTP方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 允许的请求头
                .allowedHeaders("*")
                // 允许发送cookie
                .allowCredentials(true)
                // 预检请求的有效期
                .maxAge(3600);
    }
}
