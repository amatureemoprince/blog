package com.lj.blog.application.controller.controller;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.lj.blog.application.controller.exception.exceptions.BusinessException;
import com.lj.blog.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
    private RedisUtils redisUtils;
    @PostMapping("/redis")
    public String redis(){
        redisUtils.set("test", "你好redis", 10, TimeUnit.HOURS);
        return "设置成功";
    }
    @GetMapping("/error")
    public void error(){
        throw new BusinessException("测试全局异常捕获");
    }
    @SaIgnore
    @GetMapping("/hello")
    public String hello(){
        return StpUtil.getTokenValue();
    }
}
