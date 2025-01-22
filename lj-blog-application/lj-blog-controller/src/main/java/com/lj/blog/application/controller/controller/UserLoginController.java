package com.lj.blog.application.controller.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.lj.blog.application.controller.convert.BlogUserConvert;
import com.lj.blog.application.controller.dto.BlogUserLoginDto;
import com.lj.blog.common.result.Result;
import com.lj.blog.domain.entity.BlogUserLoginBo;
import com.lj.blog.domain.serivce.imp.BlogUserDomainServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserLoginController
 * @Description 用户登录并返回SaTokenInfo
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/20 9:16
 * @Version JDK 17
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private BlogUserConvert convert;

    @Autowired
    private BlogUserDomainServiceImp blogUserDomainService;

    @PostMapping("/login")
    public Result<SaTokenInfo> login(@RequestBody BlogUserLoginDto blogUserLoginDto){
        if(log.isInfoEnabled()){
            log.info("UserLoginController.login.BlogUserLoginDto:{}", blogUserLoginDto);
        }
        BlogUserLoginBo blogUserLoginBo = convert.blogUserLoginDtoToBo(blogUserLoginDto);
        return blogUserDomainService.login(blogUserLoginBo);
    }
}
