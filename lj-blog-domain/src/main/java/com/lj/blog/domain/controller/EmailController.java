package com.lj.blog.domain.controller;

import com.lj.blog.common.enums.EmailEnum;
import com.lj.blog.common.result.Result;
import com.lj.blog.common.utils.MailUtils;
import com.lj.blog.common.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName EmailController
 * @Description 邮箱服务接口
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/20 16:01
 * @Version JDK 17
 */
@Slf4j
@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private RedisUtils redisUtils;
    @GetMapping("/captcha/sender/{email}")
    public Result<String> sender(@PathVariable("email") String email) throws UnsupportedEncodingException {
        //生成验证码
        String captcha = generateCaptcha();
        //将验证码放入redis中
        redisUtils.set(email, captcha, 3, TimeUnit.MINUTES);
        //发送
        mailUtils.sendSimpleMail(email,
                EmailEnum.CAPTCHA_SUBJECT.getMsg(),
                EmailEnum.CAPTCHA_CONTENT.getMsg() + captcha
                );
        return Result.success("发送验证码成功", captcha);
    }

    private String generateCaptcha(){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 6; i++){
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

}
