package com.lj.blog.application.controller.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.lj.blog.common.enums.GlobalEnum;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
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
@EnableKnife4j
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerOpenApi() {
        Contact contact = new Contact();
        setInfo(contact);
        return new OpenAPI()
                .openapi("3.0.3")
                .info(new Info()
                        .title(GlobalEnum.WEBSITE_NAME.getMsg())
                        .description("采用SpringBoot、minio、redis、kafka、es等中间件和一些其他技术写的一个博客系统，不为实现功能只为学习技术~~")
                        .summary("java java I love you")
                        .contact(contact)
                        .license(new License().name("Apache 2.0")
                                .url("https://github.com/amatureemoprince/blog"))
                        .version("v1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("项目github地址")
                        .url("https://github.com/amatureemoprince/blog"));
    }

    private void setInfo(Contact contact){
        contact.setName("lj-baba");
        contact.setUrl("https://github.com/amatureemoprince/blog");
        contact.setEmail("2069057986@qq.com");
    }

}
