package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogUser;

import java.util.List;

/**
 * 用户表(BlogUser)表服务接口
 *
 * @author makejava
 * @since 2025-01-20 14:11:30
 */
public interface BlogUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogUser queryById(Long id);


    /**
     * 传入一个BlogUser对象进行查询
     * */
    List<BlogUser> queryPrimary(BlogUser blogUser);

    /**
     * 分页查询
     *
     * @param blogUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */

    /**
     * 新增数据
     *
     * @param blogUser 实例对象
     * @return 实例对象
     */
    BlogUser insert(BlogUser blogUser);

    /**
     * 修改数据
     *
     * @param blogUser 实例对象
     * @return 实例对象
     */
    BlogUser update(BlogUser blogUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
