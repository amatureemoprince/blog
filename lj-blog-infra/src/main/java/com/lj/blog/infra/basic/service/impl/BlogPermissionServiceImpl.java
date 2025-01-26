package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogPermission;
import com.lj.blog.infra.basic.dao.BlogPermissionDao;
import com.lj.blog.infra.basic.service.BlogPermissionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;


/**
 * 博客权限表(BlogPermission)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 18:22:12
 */
@Service("blogPermissionService")
public class BlogPermissionServiceImpl implements BlogPermissionService {
    @Resource
    private BlogPermissionDao blogPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogPermission queryById(Integer id) {
        return this.blogPermissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param blogPermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BlogPermission> queryByPage(BlogPermission blogPermission, PageRequest pageRequest) {
        long total = this.blogPermissionDao.count(blogPermission);
        return new PageImpl<>(this.blogPermissionDao.queryAllByLimit(blogPermission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param blogPermission 实例对象
     * @return 实例对象
     */
    @Override
    public BlogPermission insert(BlogPermission blogPermission) {
        this.blogPermissionDao.insert(blogPermission);
        return blogPermission;
    }

    /**
     * 修改数据
     *
     * @param blogPermission 实例对象
     * @return 实例对象
     */
    @Override
    public BlogPermission update(BlogPermission blogPermission) {
        this.blogPermissionDao.update(blogPermission);
        return this.queryById(blogPermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogPermissionDao.deleteById(id) > 0;
    }
}
