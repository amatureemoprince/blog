package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogCategory;

import java.util.Collection;
import java.util.List;
import java.util.Set;


/**
 * 博客分类表(BlogCategory)表服务接口
 *
 * @author makejava
 * @since 2024-12-19 13:29:47
 */
public interface BlogCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogCategory queryById(Integer id);

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
    BlogCategory insert(BlogCategory blogCategory);

    /**
     * 修改数据
     *
     * @param blogCategory 实例对象
     * @return 实例对象
     */
    BlogCategory update(BlogCategory blogCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<BlogCategory> queryByIds(Collection<Integer> categoryIds);

}
