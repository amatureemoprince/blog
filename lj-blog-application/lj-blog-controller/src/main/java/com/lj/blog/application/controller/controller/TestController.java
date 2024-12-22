package com.lj.blog.application.controller.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/22 18:00
 * @Version JDK 17
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/redis")
    public String redis(){
        redisTemplate.opsForValue().set("test", "hello the world 世界");
        return "设置成功";
    }

}
