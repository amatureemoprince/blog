package com.lj.blog.domain.serivce.imp;

import com.lj.blog.common.enums.ArticleModuleEnum;
import com.lj.blog.common.result.Result;
import com.lj.blog.domain.serivce.ArticleInfoDomainService;
import com.lj.blog.infra.basic.entity.ArticleInfo;
import com.lj.blog.infra.basic.service.impl.ArticleInfoServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @ClassName ArticleInfoDomainServiceImp
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 10:59
 * @Version JDK 17
 */
@Service
public class ArticleInfoDomainServiceImp implements ArticleInfoDomainService {
    @Resource
    private ArticleInfoServiceImpl articleInfoService;
    @Override
    public Result<String> addArticleInfo(){

        return Result.success(ArticleModuleEnum.ADD_ARTICLE_INFO_SUCCESS.getMsg());
    }

    @Override
    public Result<ArticleInfo> getArticleInfo() {
        return Result.success(articleInfoService.queryById(1));
    }

}
