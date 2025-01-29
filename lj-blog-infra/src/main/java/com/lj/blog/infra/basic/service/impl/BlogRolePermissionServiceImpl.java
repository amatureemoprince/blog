package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogRolePermission;
import com.lj.blog.infra.basic.dao.BlogRolePermissionDao;
import com.lj.blog.infra.basic.service.BlogRolePermissionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Set;


/**
 * 角色权限表(BlogRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 15:17:16
 */
@Service("blogRolePermissionService")
public class BlogRolePermissionServiceImpl implements BlogRolePermissionService {
    @Resource
    private BlogRolePermissionDao blogRolePermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogRolePermission queryById(Integer id) {
        return this.blogRolePermissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param blogRolePermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BlogRolePermission> queryByPage(BlogRolePermission blogRolePermission, PageRequest pageRequest) {
        long total = this.blogRolePermissionDao.count(blogRolePermission);
        return new PageImpl<>(this.blogRolePermissionDao.queryAllByLimit(blogRolePermission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param blogRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public BlogRolePermission insert(BlogRolePermission blogRolePermission) {
        this.blogRolePermissionDao.insert(blogRolePermission);
        return blogRolePermission;
    }

    /**
     * 修改数据
     *
     * @param blogRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public BlogRolePermission update(BlogRolePermission blogRolePermission) {
        this.blogRolePermissionDao.update(blogRolePermission);
        return this.queryById(blogRolePermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogRolePermissionDao.deleteById(id) > 0;
    }

    @Override
    public Set<String> getPermissionSetByRole(Set<String> roleSet) {
        return this.blogRolePermissionDao.queryPermissionByRoles(roleSet);
    }
}
