package com.lj.blog.application.controller.controller;

import com.alibaba.fastjson.JSON;
import com.lj.blog.application.controller.convert.BlogArticleBasicInfoConvert;
import com.lj.blog.application.controller.convert.BlogUserConvert;
import com.lj.blog.application.controller.dto.BlogArticleBasicInfoDto;
import com.lj.blog.application.controller.dto.BlogUserInfoRspDto;
import com.lj.blog.common.result.PageRequest;
import com.lj.blog.common.result.Result;
import com.lj.blog.common.utils.LogUtils;
import com.lj.blog.domain.entity.BlogArticleBasicInfoBo;
import com.lj.blog.domain.entity.BlogUserInfoRspBo;
import com.lj.blog.domain.serivce.imp.BlogArticleBasicDomainServiceImp;
import com.lj.blog.domain.serivce.imp.BlogUserDomainServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BlogUserGetInfoController
 * @Description 获取普通用户的信息（包括点赞、收藏、个人信息等）
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/21 23:02
 * @Version JDK 17
 */
@Slf4j
@RestController
@RequestMapping("/user/get/")
@Tag(name = "用户获取自身信息控制器")
public class BlogUserGetInfoController {

    @Autowired
    private BlogUserDomainServiceImp blogUserDomainService;

    @Autowired
    private BlogUserConvert blogUserConvert;

    @Autowired
    private BlogArticleBasicInfoConvert blogArticleBasicInfoConvert;

    @Autowired
    private BlogArticleBasicDomainServiceImp blogArticleBasicDomainService;


    /**
     * @Description 获取用户自己的信息
     **/
    @Operation(summary = "获取自己的信息数据")
    @GetMapping("mine")
    public Result<BlogUserInfoRspDto> mine(){
        BlogUserInfoRspBo bo = blogUserDomainService.getBlogUserInfo();
        return Result.success(blogUserConvert.blogUserInfoRspBoToDto(bo));
    }

    /**
     * @Description 获取文章卡片展示的数据
     */
    @GetMapping("likes")
    @Operation(summary = "用户点赞")
    public Result<List<BlogArticleBasicInfoDto>> likes(@RequestBody PageRequest pageRequest){
        if(log.isInfoEnabled()){
            log.info(LogUtils.green("BlogUserGetInfoController.likes.PageRequest:" + JSON.toJSONString(pageRequest)));
        }
        //根据id去查询用户点赞过的文章id，再使用文章id获取文章卡片数据
        List<BlogArticleBasicInfoBo> articleBasicInfoBos = blogArticleBasicDomainService.getUserLikeArticleBasicInfo();
        List<BlogArticleBasicInfoDto> blogArticleBasicInfoDtoList = blogArticleBasicInfoConvert.toBlogArticleBasicInfoDtoList(articleBasicInfoBos);
        return Result.success(blogArticleBasicInfoDtoList);
    }

}
