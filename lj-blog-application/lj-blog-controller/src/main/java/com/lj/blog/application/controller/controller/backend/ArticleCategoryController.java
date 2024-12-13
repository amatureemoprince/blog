package com.lj.blog.application.controller.controller.backend;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lj.blog.application.controller.convert.ArticleCategoryConvert;
import com.lj.blog.application.controller.dto.article.category.AddArticleCategoryDto;
import com.lj.blog.application.controller.dto.article.category.ArticleCategoryDto;
import com.lj.blog.application.controller.dto.article.category.DeleteArticleAttributeDto;
import com.lj.blog.application.controller.dto.article.category.UpdateArticleCategoryDto;
import com.lj.blog.common.enums.ArticleModuleEnum;
import com.lj.blog.common.result.Result;
import com.lj.blog.domain.entity.ArticleCategoryBo;
import com.lj.blog.domain.serivce.imp.ArticleCategoryDomainServiceImp;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ArticleCategoryController
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 17:28
 * @Version JDK 17
 */
@Slf4j
@RestController
@RequestMapping("/backend/article/category")
public class ArticleCategoryController {
    @Resource
    private ArticleCategoryDomainServiceImp articleCategoryDomainService;
    @Resource
    private ArticleCategoryConvert convert;
    /**
     * 添加文章分类
     * */
    @PostMapping("/add")
    public Result<String> addCategory(@RequestBody AddArticleCategoryDto articleCategoryDto){
        try {
            if(log.isInfoEnabled()){
                log.info("ArticleCategoryController.addCategory.dto:{}", JSON.toJSONString(articleCategoryDto));
            }
            Preconditions.checkNotNull(articleCategoryDto.getCategoryName(), "文章标签的名称不能为空");
            ArticleCategoryBo bo = convert.toArticleCategoryBo(articleCategoryDto);
            return articleCategoryDomainService.addArticleCategory(bo);
        }catch (Exception e){
            log.error("新增文章标签错误:{}", e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }
    /**
     * 删除文章分类
     * */
    @PostMapping("/delete")
    public Result<String> deleteCategory(@RequestBody DeleteArticleAttributeDto deleteArticleCategoryDto){
        try {
            if(log.isInfoEnabled()){
                log.info("ArticleCategoryController.deleteCategory.dto:{}", JSON.toJSONString(deleteArticleCategoryDto));
            }
            Preconditions.checkNotNull(deleteArticleCategoryDto.getIds(), "要删除的文章分类不能为空");
            return articleCategoryDomainService.deleteCategoryList(deleteArticleCategoryDto.getIds());
        }catch (Exception e){
            log.error("删除文章标签错误:{}", e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }
    /**
     * 更新文章分类
     * */
    @PostMapping("/update")
    public Result<ArticleCategoryDto> updateArticleCategory(@RequestBody UpdateArticleCategoryDto updateArticleCategoryDto){
        try {
            if(log.isInfoEnabled()){
                log.info("ArticleCategoryController.updateArticleCategory.dto:{}", JSON.toJSONString(updateArticleCategoryDto));
            }
            Preconditions.checkNotNull(updateArticleCategoryDto.getId(), "要修改的文章分类id不能为空");
            ArticleCategoryBo updateArticleCategoryBo = convert.toArticleCategoryBo(updateArticleCategoryDto);
            ArticleCategoryBo articleCategoryBo = articleCategoryDomainService.updateArticleCategory(updateArticleCategoryBo);
            ArticleCategoryDto dto = convert.toDto(articleCategoryBo);
            return Result.success(ArticleModuleEnum.UPDATE_ARTICLE_CATEGORY_SUCCESS.getMsg(), dto);
        }catch (Exception e){
            log.error("更新文章分类错误:{}", e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }
    /**
     * 获取所有的文章分类
     * */
    @GetMapping("/select")
    public Result<List<ArticleCategoryDto>> getAllArticleCategory(){
        try {
            List<ArticleCategoryBo> resultBoList = articleCategoryDomainService.getAllArticleCategory();
            List<ArticleCategoryDto> dtoList = convert.toArticleCategoryDtoList(resultBoList);
            return Result.success(ArticleModuleEnum.SELECT_ARTICLE_CATEGORY_SUCCESS.getMsg(), dtoList);
        }catch (Exception e){
            log.error("获取文章分类失败:{}", e.getMessage(), e);
            return Result.error(ArticleModuleEnum.SELECT_ARTICLE_CATEGORY_ERROR.getMsg());
        }
    }
}
