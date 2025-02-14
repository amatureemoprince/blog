package com.lj.blog.common.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName DeepSeek
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/2/7 14:54
 * @Version JDK 17
 */
@Data
@Component
public class DeepSeek {

    //可以调用的api
    private static final String CHAT = "/chat/completions";

    @Value("${deepseek.base-url}")
    private String baseUrl;

    @Value("${deepseek.secret-key}")
    public String secretKey;

    public final static String MODE_CHAT = "deepseek-chat";

    public final static String MODE_REASONER = "deepseek-reasoner";



}
