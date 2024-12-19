package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogArticleBasicInfo;

/**
 * 文章基本信息表(BlogArticleBasicInfo)表服务接口
 *
 * @author makejava
 * @since 2024-12-19 13:28:09
 */
public interface BlogArticleBasicInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogArticleBasicInfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param blogArticleBasicInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param blogArticleBasicInfo 实例对象
     * @return 实例对象
     */
    BlogArticleBasicInfo insert(BlogArticleBasicInfo blogArticleBasicInfo);

    /**
     * 修改数据
     *
     * @param blogArticleBasicInfo 实例对象
     * @return 实例对象
     */
    BlogArticleBasicInfo update(BlogArticleBasicInfo blogArticleBasicInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
