package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogContentItems;

import java.util.List;

/**
 * 博客主页展示信息表(BlogContentItems)表服务接口
 *
 * @author makejava
 * @since 2024-12-18 18:49:44
 */
public interface BlogContentItemsService{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogContentItems queryById(Integer id);

    /**
     * 分页查询
     *
     * @param blogContentItems 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param blogContentItems 实例对象
     * @return 实例对象
     */
    BlogContentItems insert(BlogContentItems blogContentItems);

    /**
     * 修改数据
     *
     * @param blogContentItems 实例对象
     * @return 实例对象
     */
    BlogContentItems update(BlogContentItems blogContentItems);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<BlogContentItems> queryPrimary(BlogContentItems build);
}
