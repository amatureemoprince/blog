package com.lj.blog.application.controller.controller.backend;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lj.blog.application.controller.convert.ArticleTagConvert;
import com.lj.blog.application.controller.dto.article.category.DeleteArticleAttributeDto;
import com.lj.blog.application.controller.dto.article.tag.AddArticleTagDto;
import com.lj.blog.application.controller.dto.article.tag.ArticleTagDto;
import com.lj.blog.application.controller.dto.article.tag.UpdateArticleTagDto;
import com.lj.blog.common.enums.ArticleModuleEnum;
import com.lj.blog.common.result.Result;
import com.lj.blog.domain.entity.ArticleTagBo;
import com.lj.blog.domain.serivce.imp.ArticleTagDomainServiceImp;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ArticleTagController
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/12 11:12
 * @Version JDK 17
 */
@Slf4j
@RestController
@RequestMapping("/backend/article/tag")
public class ArticleTagController {
    @Resource
    private ArticleTagDomainServiceImp articleTagDomainService;

    @Resource
    private ArticleTagConvert convert;

    @PostMapping("/add")
    public Result<String> addArticleTag(@RequestBody AddArticleTagDto articleTagDto){
        try {
            if(log.isInfoEnabled()){
                log.info("ArticleTagController.addArticleTag.dto:{}", JSON.toJSONString(articleTagDto));
                }
            Preconditions.checkNotNull(articleTagDto.getTagName(),
                    ArticleModuleEnum.ARTICLE_TAG_NAME_NULL.getMsg());
            ArticleTagBo articleBo = convert.toArticleBo(articleTagDto);
            return articleTagDomainService.addArticleTag(articleBo);
        }catch (Exception e){
            log.error("{}{}", ArticleModuleEnum.ADD_ARTICLE_TAG_ERROR.getMsg(), e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/select")
    public Result<List<ArticleTagDto>> getAllArticleTags(){
        try {
            List<ArticleTagBo> boList = articleTagDomainService.selectAllTags(null);
            List<ArticleTagDto> result = convert.toArticleDtoList(boList);
            return Result.success(ArticleModuleEnum.SELECT_ARTICLE_TAG_SUCCESS.getMsg(), result);
        }catch (Exception e){
            log.error("查询文章标签失败:{}", e.getMessage(), e);
            return Result.error(ArticleModuleEnum.SELECT_ARTICLE_TAG_ERROR.getMsg());
        }
    }
    @PostMapping("/delete")
    public Result<String> deleteArticleTags(@RequestBody DeleteArticleAttributeDto articleAttributeDto){
        try {
            if(log.isInfoEnabled()){
                log.info("ArticleCategoryController.deleteArticleTags.dto:{}", JSON.toJSONString(articleAttributeDto));
            }
            return articleTagDomainService.deleteArticleTags(articleAttributeDto.getIds());
        }catch (Exception e){
            log.error(ArticleModuleEnum.DELETE_ARTICLE_TAG_ERROR.getMsg(), e);
            return Result.error(ArticleModuleEnum.DELETE_ARTICLE_TAG_ERROR.getMsg());
        }
    }
    @PostMapping("/update")
    public Result<ArticleTagDto> updateArticleTag(@RequestBody UpdateArticleTagDto updateArticleTagDto){
        try {
            if(log.isInfoEnabled()){
                log.info("ArticleCategoryController.updateArticleTag.dto:{}", JSON.toJSONString(updateArticleTagDto));
            }
            Preconditions.checkNotNull(updateArticleTagDto.getId(), ArticleModuleEnum.ARTICLE_TAG_ID_NULL.getMsg());
            Preconditions.checkNotNull(updateArticleTagDto.getTagName(), ArticleModuleEnum.ARTICLE_TAG_NAME_NULL.getMsg());
            ArticleTagBo articleBo = convert.toArticleBo(updateArticleTagDto);
            ArticleTagBo articleResultBo = articleTagDomainService.updateArticleTag(articleBo);
            ArticleTagDto result = convert.toArticleDto(articleResultBo);
            return Result.success(ArticleModuleEnum.UPDATE_ARTICLE_TAG_SUCCESS.getMsg(), result);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }

    }

}
