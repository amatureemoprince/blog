package com.lj.blog.domain.serivce;

import com.lj.blog.common.result.Result;
import com.lj.blog.domain.entity.ArticleTagBo;
import com.lj.blog.infra.basic.entity.ArticleTag;

import java.util.List;

/**
 * @ClassName ArticleTagDomainService
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/12 11:14
 * @Version JDK 17
 */
public interface ArticleTagDomainService {
    List<ArticleTagBo> selectAllTags(ArticleTag articleTag);
    Result<String> addArticleTag(ArticleTagBo articleBo);
    Result<String> deleteArticleTags(List<Integer> ids);
    ArticleTagBo updateArticleTag(ArticleTagBo articleBo);
}
