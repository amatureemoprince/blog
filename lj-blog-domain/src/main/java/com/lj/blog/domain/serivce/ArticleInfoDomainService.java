package com.lj.blog.domain.serivce;

import com.lj.blog.common.result.Result;
import com.lj.blog.infra.basic.entity.ArticleInfo;

/**
 * @ClassName ArticleInfoDomainService
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 10:59
 * @Version JDK 17
 */
public interface ArticleInfoDomainService {
    Result<String> addArticleInfo();
    Result<ArticleInfo> getArticleInfo();
}
