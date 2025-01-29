package com.lj.blog.common.conf;

import cn.dev33.satoken.strategy.SaAnnotationStrategy;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 * @ClassName SaTokenConfig
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/29 16:26
 * @Version JDK 17
 */
@Configuration
public class SaTokenConfig {
    @PostConstruct
    public void rewriteSaStrategy() {
        // 重写Sa-Token的注解处理器，增加注解合并功能
        SaAnnotationStrategy.instance.getAnnotation = AnnotatedElementUtils::getMergedAnnotation;
    }
}
