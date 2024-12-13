package com.lj.blog.domain.serivce.imp;

import com.alibaba.fastjson.JSON;
import com.lj.blog.common.enums.ArticleModuleEnum;
import com.lj.blog.common.result.Result;
import com.lj.blog.domain.convert.ArticleCategoryBoConvert;
import com.lj.blog.domain.entity.ArticleCategoryBo;
import com.lj.blog.domain.serivce.ArticleCategoryDomainService;
import com.lj.blog.infra.basic.entity.ArticleCategory;
import com.lj.blog.infra.basic.service.impl.ArticleCategoryServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName ArticleCategoryDomainServiceImp
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 17:47
 * @Version JDK 17
 */
@Service
@Slf4j
public class ArticleCategoryDomainServiceImp implements ArticleCategoryDomainService {
    @Resource
    private ArticleCategoryServiceImpl articleCategoryService;
    /**
     * 新增文章分类
     * */
    @Resource
    private ArticleCategoryBoConvert convert;
    @Override
    public Result<String> addArticleCategory(ArticleCategoryBo articleCategoryBo) {
        if(log.isInfoEnabled()){
            log.info("ArticleCategoryDomainServiceImp.addArticleCategory.bo:{}",
                    JSON.toJSONString(articleCategoryBo));
        }
        ArticleCategory po = convert.toArticleCategoryPo(articleCategoryBo);
        long count = articleCategoryService.count(po);
        log.info("在新增文章分类时从数据库中查询到的已存在的数据条数为:{}", count);
        if(count > 0L){
            return Result.error(ArticleModuleEnum.ARTICLE_CATEGORY_EXIST.getMsg());
        }
        if(log.isInfoEnabled()){
            log.info("ArticleCategoryDomainServiceImp.addArticleCategory.po:{}",
                    JSON.toJSONString(po));
        }
        if (articleCategoryService.insert(po) > 0){
            return Result.success(ArticleModuleEnum.ADD_ARTICLE_CATEGORY_SUCCESS.getMsg());
        }
        return Result.error(ArticleModuleEnum.ADD_ARTICLE_CATEGORY_ERROR.getMsg());
    }
    /**
     * 删除文章分类
     * */
    @Override
    public Result<String> deleteCategoryList(List<Integer> ids) {
        if(log.isInfoEnabled()){
            log.info("ArticleCategoryDomainServiceImp.deleteCategoryList.ids:{}",
                    JSON.toJSONString(ids));
        }
        int result = articleCategoryService.deleteBatch(ids);
        if(result > 0){
            return Result.success(ArticleModuleEnum.DELETE_ARTICLE_CATEGORY_SUCCESS.getMsg());
        }
        return Result.error(ArticleModuleEnum.DELETE_ARTICLE_CATEGORY_ERROR.getMsg());
    }

    @Override
    public List<ArticleCategoryBo> getAllArticleCategory() {
        if(log.isInfoEnabled()){
            log.info("ArticleCategoryDomainServiceImp.getAllArticleCategory:{}",
                    JSON.toJSONString(null));
        }
        List<ArticleCategory> poList = articleCategoryService.queryPrimary();
        log.info("查询到{}条文章分类记录", poList.size());
        List<ArticleCategoryBo> boList = convert.toBOList(poList);
        return CollectionUtils.isEmpty(boList) ?
                Collections.emptyList() : boList;
    }

    @Override
    public ArticleCategoryBo updateArticleCategory(ArticleCategoryBo updateArticleCategoryBo) {
        if(log.isInfoEnabled()){
            log.info("ArticleCategoryDomainServiceImp.updateArticleCategory.updateArticleCategoryBo:{}",
                    JSON.toJSONString(updateArticleCategoryBo));
        }
        ArticleCategory po = convert.toArticleCategoryPo(updateArticleCategoryBo);
        ArticleCategory update = articleCategoryService.update(po);
        ArticleCategoryBo bo = convert.toBO(update);
        if(update != null){
            return bo;
        }
        return updateArticleCategoryBo;
    }
}
