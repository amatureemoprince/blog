package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogRolePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 角色权限表(BlogRolePermission)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 15:17:16
 */
public interface BlogRolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogRolePermission queryById(Integer id);

    /**
     * 分页查询
     *
     * @param blogRolePermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BlogRolePermission> queryByPage(BlogRolePermission blogRolePermission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param blogRolePermission 实例对象
     * @return 实例对象
     */
    BlogRolePermission insert(BlogRolePermission blogRolePermission);

    /**
     * 修改数据
     *
     * @param blogRolePermission 实例对象
     * @return 实例对象
     */
    BlogRolePermission update(BlogRolePermission blogRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
