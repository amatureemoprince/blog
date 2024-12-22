package com.lj.blog.domain.serivce.imp;

import com.alibaba.fastjson.JSON;
import com.lj.blog.common.enums.TypeEnum;
import com.lj.blog.common.result.PageRequest;
import com.lj.blog.domain.convert.BlogArticleInfoBoConvert;
import com.lj.blog.domain.entity.BlogArticleBasicInfoBo;
import com.lj.blog.domain.entity.BlogArticleContentBo;
import com.lj.blog.domain.serivce.BlogArticleBasicInfoDomainService;
import com.lj.blog.infra.basic.entity.*;
import com.lj.blog.infra.basic.service.impl.*;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName BlogArticleBasicDomainServiceImp
 * @Description 主页文章展示数据服务类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/19 21:04
 * @Version JDK 17
 */
@Service
@Slf4j
public class BlogArticleBasicDomainServiceImp implements BlogArticleBasicInfoDomainService {
    @Resource
    private BlogArticleInfoBoConvert convert;

    @Resource
    private BlogArticleBasicInfoServiceImpl basicInfoService;

    @Resource
    private BlogCategoryServiceImpl categoryService;

    @Resource
    private BlogLabelServiceImpl labelService;

    @Resource
    private BlogArticleCategoryLabelMappingServiceImpl mappingService;

    @Resource
    private BlogArticleStatusServiceImpl statusService;

    @Resource
    private BlogArticleContentServiceImpl blogArticleContentService;
    /**
     *
     * */
    @Transactional
    @Override
    public List<BlogArticleBasicInfoBo> getBlogArticleBasicInfo(PageRequest pageRequest) {
        if (log.isInfoEnabled()) {
            log.info("BlogArticleBasicDomainServiceImp.getBlogArticleBasicInfo.pageRequest:{}", JSON.toJSONString(pageRequest));
        }
        //查询到10条基本信息数据
        List<BlogArticleBasicInfo> poList = basicInfoService.queryLimit(null, pageRequest);
        if (poList.isEmpty()) {
            return new ArrayList<>();
        }
        //获取到所有的文章id
        List<Integer> articleIds = poList.stream()
                .map(BlogArticleBasicInfo::getId)
                .toList();
        //查询到关联信息
        List<BlogArticleCategoryLabelMapping> allMappings = mappingService.queryByArticleIds(articleIds);
        //文章id和分类、标签的对应关系
        Map<Integer, Integer> articleToCategoryMap = new HashMap<>();
        Map<Integer, List<Integer>> articleToLabelIdsMap = new HashMap<>();
        for (BlogArticleCategoryLabelMapping mapping : allMappings) {
            Integer articleId = mapping.getArticleId();
            // 处理分类（只取第一个，因为一篇文章只对应一个分类）
            if (!articleToCategoryMap.containsKey(articleId)) {
                articleToCategoryMap.put(articleId, mapping.getCategoryId());
            }
            // 处理标签（收集所有标签）
            articleToLabelIdsMap.computeIfAbsent(articleId, k -> new ArrayList<>())
                    .add(mapping.getLabelId());
        }

        Set<Integer> categoryIds = new HashSet<>(articleToCategoryMap.values());
        Map<Integer, BlogCategory> blogCategoryMap = categoryService.queryByIds(categoryIds)
                .stream()
                .collect(Collectors.toMap(BlogCategory::getId, blogCategory -> blogCategory));


        Set<Integer> labelIds = articleToLabelIdsMap.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        Map<Integer, BlogLabel> blogLabelMap = labelService.queryByIds(labelIds)
                .stream()
                .collect(Collectors.toMap(BlogLabel::getId, blogLabel -> blogLabel));

        Map<Integer, BlogArticleStatus> statusMap = statusService.queryByArticleIds(articleIds)
                .stream()
                .collect(Collectors.toMap(BlogArticleStatus::getArticleId, status -> status));
        //组装数据
        List<BlogArticleBasicInfoBo> boList = new ArrayList<>();
        for (BlogArticleBasicInfo po : poList) {
            Integer articleId = po.getId();
            //获取分类
            BlogCategory blogCategory = blogCategoryMap.get(articleToCategoryMap.get(articleId));
            // 获取标签列表
            List<BlogLabel> labels = articleToLabelIdsMap.getOrDefault(articleId, new ArrayList<>())
                    .stream()
                    .map(blogLabelMap::get)
                    .filter(Objects::nonNull)
                    .toList();
            BlogArticleStatus status = statusMap.get(articleId);
            boList.add(convert.toBlogArticleBasicInfoConvertBo(po, blogCategory, labels, status));
        }
        if(log.isInfoEnabled()){
            log.info("BlogArticleBasicDomainServiceImp.getBlogArticleBasicInf.boList{}", boList);
        }
        return boList;
    }

    @Override
    public BlogArticleContentBo getArticleContent(Integer articleId) {
        BlogArticleContent articleContent = blogArticleContentService.queryPrimary(BlogArticleContent
                .builder()
                .articleId(articleId)
                .isDeleted(TypeEnum.IS_NOT_DELETED.getCode())
                .build());
        BlogArticleContentBo blogArticleContentBo = convert.toBlogArticleContentBo(articleContent);
        if (log.isInfoEnabled()) {
            log.info("BlogArticleBasicDomainServiceImp.getArticleContent.bo:{}", JSON.toJSONString(blogArticleContentBo));
        }
        return blogArticleContentBo;
    }

    @Override
    public Integer getCount(BlogArticleBasicInfo info){
        return basicInfoService.count(info);
    }

}
