package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogArticleStatus;


/**
 * 文章统计表(BlogArticleStatus)表服务接口
 *
 * @author makejava
 * @since 2024-12-19 13:29:28
 */
public interface BlogArticleStatusService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogArticleStatus queryById(Integer id);

    /**
     * 分页查询
     *
     * @param blogArticleStatus 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param blogArticleStatus 实例对象
     * @return 实例对象
     */
    BlogArticleStatus insert(BlogArticleStatus blogArticleStatus);

    /**
     * 修改数据
     *
     * @param blogArticleStatus 实例对象
     * @return 实例对象
     */
    BlogArticleStatus update(BlogArticleStatus blogArticleStatus);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
