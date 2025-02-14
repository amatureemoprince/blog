package com.lj.blog.application.controller.deepseek;

import com.lj.blog.common.annotation.AspectLog;
import com.lj.blog.common.exception.exceptions.BusinessException;
import com.lj.blog.domain.ai.AiService;
import io.swagger.v3.oas.annotations.tags.Tag;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @ClassName DeepSeekController
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/2/7 16:22
 * @Version JDK 17
 */
@Tag(name = "deepseek控制器")
@RestController
@RequestMapping("/deep-seek")
public class DeepSeekController {

    private final AiService aiService;

    public DeepSeekController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/chat")
    @AspectLog(pre = "开始请求deepseek", later = "deepseek完成了")
    public Response chat(){
        try {
            return aiService.chat();
        } catch (IOException e) {
            throw new BusinessException("获取deepseek信息出错");
        }
    }

}
