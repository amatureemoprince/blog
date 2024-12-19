package com.lj.blog.application.controller.controller;

import com.lj.blog.application.controller.convert.BlogContentItemConvert;
import com.lj.blog.application.controller.dto.BlogContentDto;
import com.lj.blog.common.result.Result;
import com.lj.blog.domain.entity.BlogContentItemsBo;
import com.lj.blog.domain.serivce.imp.BlogContentItemsDomainServiceImp;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BlogContentItemsController
 * @Description 获取主页展示信息api
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/18 18:53
 * @Version JDK 17
 */
@RestController
@RequestMapping("/home")
public class BlogContentItemsController {
    @Resource
    private BlogContentItemsDomainServiceImp serviceImp;
    @Resource
    private BlogContentItemConvert convert;
    @GetMapping("/sentences")
    public Result<BlogContentDto> getSentences(){
        List<BlogContentItemsBo> result = serviceImp.getAllSentences();
        BlogContentDto blogContentDto = convert.blogContentBoToDto(result);
        return Result.success(blogContentDto);
    }
}
