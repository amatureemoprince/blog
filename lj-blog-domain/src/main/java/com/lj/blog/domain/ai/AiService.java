package com.lj.blog.domain.ai;

import okhttp3.Response;

import java.io.IOException;

/**
 * @ClassName AiService
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/2/8 11:18
 * @Version JDK 17
 */
public interface AiService {
    Response chat() throws IOException;
}
