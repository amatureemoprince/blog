package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogArticleCategoryLabelMapping;

import java.util.List;

/**
 * 文章分类标签关系表(BlogArticleCategoryLabelMapping)表服务接口
 *
 * @author makejava
 * @since 2024-12-19 13:28:39
 */
public interface BlogArticleCategoryLabelMappingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogArticleCategoryLabelMapping queryById(Integer id);

    /**
     * 分页查询
     *
     * @param blogArticleCategoryLabelMapping 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */

    /**
     * 新增数据
     *
     * @param blogArticleCategoryLabelMapping 实例对象
     * @return 实例对象
     */
    BlogArticleCategoryLabelMapping insert(BlogArticleCategoryLabelMapping blogArticleCategoryLabelMapping);

    /**
     * 修改数据
     *
     * @param blogArticleCategoryLabelMapping 实例对象
     * @return 实例对象
     */
    BlogArticleCategoryLabelMapping update(BlogArticleCategoryLabelMapping blogArticleCategoryLabelMapping);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<BlogArticleCategoryLabelMapping> queryPrimary(BlogArticleCategoryLabelMapping build);

    List<BlogArticleCategoryLabelMapping> queryByArticleIds(List<Integer> articleIds);
}
