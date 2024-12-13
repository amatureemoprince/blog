package com.lj.blog.domain.serivce.imp;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lj.blog.common.enums.ArticleModuleEnum;
import com.lj.blog.common.result.Result;
import com.lj.blog.domain.convert.ArticleTagBoConvert;
import com.lj.blog.domain.entity.ArticleTagBo;
import com.lj.blog.domain.serivce.ArticleTagDomainService;
import com.lj.blog.infra.basic.entity.ArticleTag;
import com.lj.blog.infra.basic.service.impl.ArticleTagServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ArticleTagDomainServiceImp
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/12 11:15
 * @Version JDK 17
 */
@Service
@Slf4j
public class ArticleTagDomainServiceImp implements ArticleTagDomainService {

    @Resource
    private ArticleTagServiceImpl articleTagService;
    @Resource
    private ArticleTagBoConvert convert;
    @Override
    public List<ArticleTagBo> selectAllTags(ArticleTag articleTag) {
        if(log.isInfoEnabled()){
            log.info("ArticleTagDomainServiceImp.selectAllTags.po:{}",
                    JSON.toJSONString(articleTag));
        }
        List<ArticleTag> articleTags = articleTagService.queryPrimary(articleTag);
        List<ArticleTagBo> articleTagBoList = convert.toArticleTagBoList(articleTags);
        if(log.isInfoEnabled()){
            log.info("ArticleTagDomainServiceImp.selectAllTags.boList:{}",
                    JSON.toJSONString(articleTags));
        }
        return articleTagBoList;
    }

    @Override
    public Result<String> addArticleTag(ArticleTagBo articleBo) {
        if(log.isInfoEnabled()){
            log.info("ArticleTagDomainServiceImp.addArticleTag.bo:{}",
                    JSON.toJSONString(articleBo));
        }
        ArticleTag article = convert.toArticleTagPo(articleBo);
        long counts = articleTagService.counts(article);
        log.info("查询出{}条文章标签", counts);
        if(counts > 0){
            return Result.error(ArticleModuleEnum.ARTICLE_TAG_EXIST.getMsg());
        }
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        article.setIsDeleted(0);
        int insert = articleTagService.insert(article);
        if(insert > 0){
            return Result.success(ArticleModuleEnum.ADD_ARTICLE_TAG_SUCCESS.getMsg());
        }
        return Result.error(ArticleModuleEnum.ADD_ARTICLE_TAG_ERROR.getMsg());
    }

    @Override
    public Result<String> deleteArticleTags(List<Integer> ids) {
        int result = articleTagService.deleteByIds(ids);
        if(result > 0){
            return Result.success(ArticleModuleEnum.DELETE_ARTICLE_TAG_SUCCESS.getMsg());
        }
        return Result.error(ArticleModuleEnum.DELETE_ARTICLE_TAG_ERROR.getMsg());
    }

    @Override
    public ArticleTagBo updateArticleTag(ArticleTagBo articleBo) {
        ArticleTag articleTagPo = convert.toArticleTagPo(articleBo);
        articleTagPo.setUpdateTime(new Date());
        ArticleTag update = articleTagService.update(articleTagPo);
        ArticleTagBo articleTagBo = convert.toArticleTagBo(update);
        if(update != null){
            return articleTagBo;
        }
        return articleBo;
    }
}
