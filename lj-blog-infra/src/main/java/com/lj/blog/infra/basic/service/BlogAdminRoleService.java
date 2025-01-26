package com.lj.blog.infra.basic.service;

import com.lj.blog.infra.basic.entity.BlogAdminRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 博客管理员角色表(BlogAdminRole)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 18:28:14
 */
public interface BlogAdminRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogAdminRole queryById(Integer id);

    /**
     * 分页查询
     *
     * @param blogAdminRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BlogAdminRole> queryByPage(BlogAdminRole blogAdminRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param blogAdminRole 实例对象
     * @return 实例对象
     */
    BlogAdminRole insert(BlogAdminRole blogAdminRole);

    /**
     * 修改数据
     *
     * @param blogAdminRole 实例对象
     * @return 实例对象
     */
    BlogAdminRole update(BlogAdminRole blogAdminRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
