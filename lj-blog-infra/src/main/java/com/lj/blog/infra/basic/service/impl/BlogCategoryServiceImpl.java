package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogCategory;
import com.lj.blog.infra.basic.dao.BlogCategoryDao;
import com.lj.blog.infra.basic.service.BlogCategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 博客分类表(BlogCategory)表服务实现类
 *
 * @author makejava
 * @since 2024-12-19 13:29:47
 */
@Service("blogCategoryService")
public class BlogCategoryServiceImpl implements BlogCategoryService {
    @Resource
    private BlogCategoryDao blogCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogCategory queryById(Integer id) {
        return this.blogCategoryDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param blogCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param blogCategory 实例对象
     * @return 实例对象
     */
    @Override
    public BlogCategory insert(BlogCategory blogCategory) {
        this.blogCategoryDao.insert(blogCategory);
        return blogCategory;
    }

    /**
     * 修改数据
     *
     * @param blogCategory 实例对象
     * @return 实例对象
     */
    @Override
    public BlogCategory update(BlogCategory blogCategory) {
        this.blogCategoryDao.update(blogCategory);
        return this.queryById(blogCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogCategoryDao.deleteById(id) > 0;
    }
}
