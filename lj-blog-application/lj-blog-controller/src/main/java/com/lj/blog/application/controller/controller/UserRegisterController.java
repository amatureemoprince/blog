package com.lj.blog.application.controller.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lj.blog.application.controller.convert.BlogUserConvert;
import com.lj.blog.application.controller.dto.BlogUserRegisterDto;
import com.lj.blog.common.result.Result;
import com.lj.blog.common.utils.LogUtils;
import com.lj.blog.common.utils.MailUtils;
import com.lj.blog.domain.serivce.imp.BlogUserDomainServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserRegisterController
 * @Description 用户注册：用户只需要设置自己昵称，使用系统给出的userName
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/20 9:19
 * @Version JDK 17
 */

@Slf4j
@RestController
@RequestMapping("/user")
@Tag(name = "注册控制器")
public class UserRegisterController {

    private final BlogUserDomainServiceImp blogUserDomainService;
    private final BlogUserConvert convert;
    private final MailUtils mailUtils;
    @Autowired
    public UserRegisterController(BlogUserDomainServiceImp blogUserDomainService, BlogUserConvert convert, MailUtils mailUtils) {
        this.blogUserDomainService = blogUserDomainService;
        this.convert = convert;
        this.mailUtils = mailUtils;
    }

    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public Result<String> register(@RequestBody BlogUserRegisterDto registerDto) {
        try {
            Preconditions.checkNotNull(registerDto.getPassword(), "密码不能为空");
            Preconditions.checkNotNull(registerDto.getEmail(), "邮箱不能为空");
            Preconditions.checkNotNull(registerDto.getNickName(), "用户昵称不能为空");
            Preconditions.checkNotNull(registerDto.getCaptcha(), "验证码不能为空");
            Preconditions.checkNotNull(registerDto.getSex(), "性别不能为空");
            if (log.isInfoEnabled()) {
                log.info("UserRegisterController.register.BlogUserRegisterDto:{}", JSON.toJSONString(registerDto));
            }
            if (mailUtils.checkCaptcha(registerDto.getEmail(), registerDto.getCaptcha())) {
                return blogUserDomainService.register(convert.blogRegisterDtoToBlogUser(registerDto));
            }
            return Result.error("验证码验证错误");
        } catch (Exception e) {
            log.info(LogUtils.red("注册普通用户失败 " + e + " " + e.getMessage()));
            return Result.error(e.getMessage());
        }
    }
}
