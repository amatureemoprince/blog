package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 博客权限表(BlogPermission)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 18:22:12
 */
public interface BlogPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogPermission queryById(Integer id);

    /**
     * 分页查询
     *
     * @param blogPermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BlogPermission> queryByPage(BlogPermission blogPermission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param blogPermission 实例对象
     * @return 实例对象
     */
    BlogPermission insert(BlogPermission blogPermission);

    /**
     * 修改数据
     *
     * @param blogPermission 实例对象
     * @return 实例对象
     */
    BlogPermission update(BlogPermission blogPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
