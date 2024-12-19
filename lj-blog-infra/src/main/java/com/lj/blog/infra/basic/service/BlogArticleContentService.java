package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogArticleContent;


/**
 * 文章内容表(BlogArticleContent)表服务接口
 *
 * @author makejava
 * @since 2024-12-19 13:29:00
 */
public interface BlogArticleContentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogArticleContent queryById(Integer id);

    /**
     * 分页查询
     *
     * @param blogArticleContent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param blogArticleContent 实例对象
     * @return 实例对象
     */
    BlogArticleContent insert(BlogArticleContent blogArticleContent);

    /**
     * 修改数据
     *
     * @param blogArticleContent 实例对象
     * @return 实例对象
     */
    BlogArticleContent update(BlogArticleContent blogArticleContent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
