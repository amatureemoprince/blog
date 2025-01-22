package com.lj.blog.application.controller.controller;

import com.lj.blog.common.result.Result;
import com.lj.blog.domain.serivce.imp.BlogFileDomainServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName UserAvatarController
 * @Description 用户上传、更新头像
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/22 14:29
 * @Version JDK 17
 */
@RestController
@RequestMapping("/user/avatar/")
public class UserAvatarController {

    @Autowired
    private BlogFileDomainServiceImp fileService;

    @PostMapping("upload")
    public Result<String> upload(@RequestParam("avatar") MultipartFile avatar){
        return fileService.uploadAvatar(avatar);
    }

}
