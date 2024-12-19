package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogArticleCategoryLabelMapping;
import com.lj.blog.infra.basic.dao.BlogArticleCategoryLabelMappingDao;
import com.lj.blog.infra.basic.service.BlogArticleCategoryLabelMappingService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 文章分类标签关系表(BlogArticleCategoryLabelMapping)表服务实现类
 *
 * @author makejava
 * @since 2024-12-19 13:28:39
 */
@Service("blogArticleCategoryLabelMappingService")
public class BlogArticleCategoryLabelMappingServiceImpl implements BlogArticleCategoryLabelMappingService {
    @Resource
    private BlogArticleCategoryLabelMappingDao blogArticleCategoryLabelMappingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogArticleCategoryLabelMapping queryById(Integer id) {
        return this.blogArticleCategoryLabelMappingDao.queryById(id);
    }

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
    @Override
    public BlogArticleCategoryLabelMapping insert(BlogArticleCategoryLabelMapping blogArticleCategoryLabelMapping) {
        this.blogArticleCategoryLabelMappingDao.insert(blogArticleCategoryLabelMapping);
        return blogArticleCategoryLabelMapping;
    }

    /**
     * 修改数据
     *
     * @param blogArticleCategoryLabelMapping 实例对象
     * @return 实例对象
     */
    @Override
    public BlogArticleCategoryLabelMapping update(BlogArticleCategoryLabelMapping blogArticleCategoryLabelMapping) {
        this.blogArticleCategoryLabelMappingDao.update(blogArticleCategoryLabelMapping);
        return this.queryById(blogArticleCategoryLabelMapping.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogArticleCategoryLabelMappingDao.deleteById(id) > 0;
    }
}
