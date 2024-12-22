package com.lj.blog.application.controller.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lj.blog.application.controller.convert.BlogArticleBasicInfoConvert;
import com.lj.blog.application.controller.dto.BlogArticleBasicInfoDto;
import com.lj.blog.application.controller.dto.BlogArticleContentDto;
import com.lj.blog.common.enums.TypeEnum;
import com.lj.blog.common.result.PageRequest;
import com.lj.blog.common.result.PageResponse;
import com.lj.blog.common.result.Result;
import com.lj.blog.domain.entity.BlogArticleBasicInfoBo;
import com.lj.blog.domain.entity.BlogArticleContentBo;
import com.lj.blog.domain.serivce.imp.BlogArticleBasicDomainServiceImp;
import com.lj.blog.infra.basic.entity.BlogArticleBasicInfo;
import com.lj.blog.infra.basic.entity.BlogArticleContent;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BlogArticleInfoController
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/19 21:32
 * @Version JDK 17
 */
@Slf4j
@RestController
@RequestMapping("/home")
public class BlogArticleInfoController {
    @Resource
    private BlogArticleBasicDomainServiceImp blogArticleBasicDomainService;
    @Resource
    private BlogArticleBasicInfoConvert convert;
    @PostMapping("/articles")
    public Result<PageResponse<BlogArticleBasicInfoDto>> getBlogArticleInfos(
            @RequestBody PageRequest pageRequest){
        try {
            Preconditions.checkNotNull(pageRequest.getPageNum(), "请求页数不能为空");
            Preconditions.checkNotNull(pageRequest.getPageSize(), "请求页码不能为空");
            List<BlogArticleBasicInfoBo> blogArticleBasicInfo = blogArticleBasicDomainService.getBlogArticleBasicInfo(pageRequest);
            List<BlogArticleBasicInfoDto> basicInfoDtos = convert.toBlogArticleBasicInfoDtoList(blogArticleBasicInfo);
            if(log.isInfoEnabled()){
                log.info("BlogArticleInfoController.getBlogArticleInfos.dto:{}", JSON.toJSONString(basicInfoDtos));
            }
            PageResponse<BlogArticleBasicInfoDto> pageResponse = new PageResponse<>();
            pageResponse.setCurrentPageNum(pageRequest.getPageNum());
            pageResponse.setPageSize(pageRequest.getPageSize());
            pageResponse.setTotal(blogArticleBasicDomainService.getCount(BlogArticleBasicInfo.builder()
                            .isDeleted(TypeEnum.IS_NOT_DELETED.getCode())
                    .build()));
            pageResponse.setRecords(basicInfoDtos);
            return Result.success("获取文章卡片内容成功", pageResponse);

        }catch (Exception e){
            log.error("获取文章基本信息失败", e);
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public Result<BlogArticleContentDto> getArticleContent(@PathVariable("id") Integer id){
        try {
            if(log.isInfoEnabled()){
                log.info("BlogArticleInfoController.getArticleContent.id:{}", id);
            }
            BlogArticleContentBo bo = blogArticleBasicDomainService.getArticleContent(id);
            BlogArticleContentDto dto = convert.toBlogArticleContentDto(bo);
            return Result.success("获取文章详细内容成功", dto);
        }catch (Exception e){
            log.error("获取文章详细内容出错", e);
            return Result.error("获取文章详细内容出错");
        }
    }
}