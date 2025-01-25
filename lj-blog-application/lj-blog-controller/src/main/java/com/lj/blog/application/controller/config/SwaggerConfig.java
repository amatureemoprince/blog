package com.lj.blog.application.controller.config;

import com.lj.blog.common.enums.GlobalEnum;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SwaggerConfig
 * @Description 配置swagger-ui
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/25 9:30
 * @Version JDK 17
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI swaggerOpenApi() {
        return new OpenAPI()
                .info(new Info().title(GlobalEnum.WEBSITE_NAME.getMsg())
                        .description("博客接口开发")
                        .version("v1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("项目github地址")
                        .url("https://github.com/amatureemoprince/blog"));
    }
}
