package com.lj.blog.domain.serivce;

import com.lj.blog.common.result.PageRequest;
import com.lj.blog.common.result.PageResponse;
import com.lj.blog.domain.entity.BlogArticleBasicInfoBo;
import com.lj.blog.domain.entity.BlogArticleContentBo;
import com.lj.blog.infra.basic.entity.BlogArticleBasicInfo;

import java.util.List;

/**
 * @ClassName BlogArticleBasicInfoDomainService
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/19 21:04
 * @Version JDK 17
 */
public interface BlogArticleBasicInfoDomainService {
    /**
     * 分页获取文章基本信息
     * 并通过查询到的数据去整合其他类中的数据封装返回
     * */
    List<BlogArticleBasicInfoBo> getBlogArticleBasicInfo(PageRequest pageRequest);
    /**
     * 根据文章id查询详细内容
     * */
    BlogArticleContentBo getArticleContent(Integer articleId);

    Integer getCount(BlogArticleBasicInfo info);

    List<BlogArticleBasicInfoBo> getUserLikeArticleBasicInfo();
}
