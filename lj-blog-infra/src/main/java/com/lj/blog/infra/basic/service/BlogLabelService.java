package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogLabel;


/**
 * 博客标签表(BlogLabel)表服务接口
 *
 * @author makejava
 * @since 2024-12-19 13:30:09
 */
public interface BlogLabelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogLabel queryById(Integer id);

    /**
     * 分页查询
     *
     * @param blogLabel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param blogLabel 实例对象
     * @return 实例对象
     */
    BlogLabel insert(BlogLabel blogLabel);

    /**
     * 修改数据
     *
     * @param blogLabel 实例对象
     * @return 实例对象
     */
    BlogLabel update(BlogLabel blogLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
