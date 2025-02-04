package com.lj.blog.application.controller.test;

import cn.dev33.satoken.annotation.SaIgnore;
import com.lj.blog.application.controller.test.dto.HashSetUser;
import com.lj.blog.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RedisController
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/2/1 7:29
 * @Version JDK 17
 */
@RestController
@SaIgnore
@RequestMapping("/test2")
public class RedisController {
    private final RedisUtils redisUtils;
    @Autowired
    public RedisController(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }
    @GetMapping("/hash")
    public String hash(){
        redisUtils.hset("hash-set", "user", "lj");
        redisUtils.hset("hash-set", "password", "200481lj");
        return "设置hash到redis中成功";
    }

    @GetMapping("/getHash")
    public HashSetUser getHash(){
        Object user = redisUtils.hget("hash-set", "user");
        Object password = redisUtils.hget("hash-set", "password");
        HashSetUser hashSetUser = new HashSetUser();
        hashSetUser.setUser((String) user);
        hashSetUser.setPassword((String) password);
        return hashSetUser;
    }
}
