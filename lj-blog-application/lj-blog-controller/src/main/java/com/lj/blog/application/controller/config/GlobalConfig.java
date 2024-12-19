package com.lj.blog.application.controller.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import java.util.List;
/**
 * @ClassName GlobalConfig
 * @Description 使得可以创建值为null的bean并且如果返回为null自动拦截处理
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/14 9:55
 * @Version JDK 17
 */
@Configuration
public class GlobalConfig extends WebMvcConfigurationSupport {
    @Override
    protected void configureMessageConverters(@NonNull List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(mappingJackson2HttpMessageConverter());
    }
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }
}
