package com.lj.blog.domain.ai.imp;

import cn.hutool.json.JSONUtil;
import com.lj.blog.common.constant.DeepSeek;
import com.lj.blog.domain.ai.AiService;
import okhttp3.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @ClassName DeepSeekServiceImp
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/2/8 11:19
 * @Version JDK 17
 */
@Service
@Primary
public class DeepSeekServiceImp implements AiService {

    private final DeepSeek deepSeek;

    public DeepSeekServiceImp(DeepSeek deepSeek) {
        this.deepSeek = deepSeek;
    }

    @Override
    public Response chat() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody
                .create(
                        mediaType,
                        "{\n  \"messages\": [\n    {\n      \"content\": \"You are a helpful assistant\",\n      \"role\": \"system\"\n    },\n    {\n      \"content\": \"Hi\",\n      \"role\": \"user\"\n    }\n  ],\n  \"model\": \"deepseek-chat\",\n  \"frequency_penalty\": 0,\n  \"max_tokens\": 2048,\n  \"presence_penalty\": 0,\n  \"response_format\": {\n    \"type\": \"text\"\n  },\n  \"stop\": null,\n  \"stream\": false,\n  \"stream_options\": null,\n  \"temperature\": 1,\n  \"top_p\": 1,\n  \"tools\": null,\n  \"tool_choice\": \"none\",\n  \"logprobs\": false,\n  \"top_logprobs\": null\n}");
        Request request = new Request.Builder()
                .url("https://api.deepseek.com/chat/completions")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer sk-397066a7f0834b509916fc7e6b761225")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(JSONUtil.parse(response.body()));
        return response;
    }
}
