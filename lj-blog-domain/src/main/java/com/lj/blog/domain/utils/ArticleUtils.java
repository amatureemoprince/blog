package com.lj.blog.domain.utils;

import com.lj.blog.infra.basic.entity.BlogArticleCategoryLabelMapping;
import com.lj.blog.infra.basic.entity.BlogArticleStatus;
import com.lj.blog.infra.basic.entity.BlogCategory;
import com.lj.blog.infra.basic.entity.BlogLabel;
import com.lj.blog.infra.basic.service.impl.BlogArticleCategoryLabelMappingServiceImpl;
import com.lj.blog.infra.basic.service.impl.BlogArticleStatusServiceImpl;
import com.lj.blog.infra.basic.service.impl.BlogCategoryServiceImpl;
import com.lj.blog.infra.basic.service.impl.BlogLabelServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName ArticleUtils
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/19 22:16
 * @Version JDK 17
 */
@Component
public class ArticleUtils {
    @Resource
    private BlogArticleCategoryLabelMappingServiceImpl blogArticleCategoryLabelMappingService;
    @Resource
    private BlogArticleStatusServiceImpl blogArticleStatusService;
    @Resource
    private BlogCategoryServiceImpl blogCategoryService;
    @Resource
    private BlogLabelServiceImpl blogLabelService;

    @Transactional(rollbackFor = Exception.class)
    public String getCategory(Integer articleId) {
        if (articleId == null) {
            return null;
        }
        List<BlogArticleCategoryLabelMapping> mapping = blogArticleCategoryLabelMappingService.queryPrimary(
                BlogArticleCategoryLabelMapping.builder().articleId(articleId).build()
        );
        if (mapping == null || mapping.isEmpty()) {
            return null;
        }
        BlogCategory blogCategory = blogCategoryService.queryById(mapping.get(0).getCategoryId());
        return blogCategory != null ? blogCategory.getCategory() : null;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<String> getLabels(Integer articleId) {
        if (articleId == null) {
            return List.of();
        }
        List<BlogArticleCategoryLabelMapping> mappings = blogArticleCategoryLabelMappingService.queryPrimary(
                BlogArticleCategoryLabelMapping.builder()
                        .articleId(articleId)
                        .build()
        );
        return mappings.stream()
                .map(BlogArticleCategoryLabelMapping::getLabelId)
                .filter(Objects::nonNull)
                .map(labelId -> blogLabelService.queryById(labelId))
                .filter(Objects::nonNull)
                .map(BlogLabel::getLabel)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer getStatus(Integer articleId, Integer tag) {
        if (articleId == null || tag == null) {
            return 0;
        }
        BlogArticleStatus blogArticleStatus = blogArticleStatusService.queryById(articleId);
        if (blogArticleStatus == null) {
            return 0;
        }
        return switch (tag) {
            case 1 -> blogArticleStatus.getLikes();
            case 2 -> blogArticleStatus.getViews();
            case 3 -> blogArticleStatus.getComments();
            case 4 -> blogArticleStatus.getCollections();
            default -> 0;
        };
    }
}
