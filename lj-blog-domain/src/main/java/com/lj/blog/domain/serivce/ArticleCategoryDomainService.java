package com.lj.blog.domain.serivce;

import com.lj.blog.common.result.Result;
import com.lj.blog.domain.entity.ArticleCategoryBo;
import com.lj.blog.infra.basic.entity.ArticleCategory;

import java.util.List;

/**
 * @ClassName ArticleCategoryDomainService
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 17:47
 * @Version JDK 17
 */
public interface ArticleCategoryDomainService {
    Result<String> addArticleCategory(ArticleCategoryBo articleCategoryBo);

    Result<String> deleteCategoryList(List<Integer> ids);

    List<ArticleCategoryBo> getAllArticleCategory();

    Result<String> updateArticleCategory(ArticleCategoryBo updateArticleCategoryBo);
}
