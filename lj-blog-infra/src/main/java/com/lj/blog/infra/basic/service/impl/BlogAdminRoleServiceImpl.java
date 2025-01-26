package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogAdminRole;
import com.lj.blog.infra.basic.dao.BlogAdminRoleDao;
import com.lj.blog.infra.basic.service.BlogAdminRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

/**
 * 博客管理员角色表(BlogAdminRole)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 18:28:14
 */
@Service("blogAdminRoleService")
public class BlogAdminRoleServiceImpl implements BlogAdminRoleService {
    @Resource
    private BlogAdminRoleDao blogAdminRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogAdminRole queryById(Integer id) {
        return this.blogAdminRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param blogAdminRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BlogAdminRole> queryByPage(BlogAdminRole blogAdminRole, PageRequest pageRequest) {
        long total = this.blogAdminRoleDao.count(blogAdminRole);
        return new PageImpl<>(this.blogAdminRoleDao.queryAllByLimit(blogAdminRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param blogAdminRole 实例对象
     * @return 实例对象
     */
    @Override
    public BlogAdminRole insert(BlogAdminRole blogAdminRole) {
        this.blogAdminRoleDao.insert(blogAdminRole);
        return blogAdminRole;
    }

    /**
     * 修改数据
     *
     * @param blogAdminRole 实例对象
     * @return 实例对象
     */
    @Override
    public BlogAdminRole update(BlogAdminRole blogAdminRole) {
        this.blogAdminRoleDao.update(blogAdminRole);
        return this.queryById(blogAdminRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogAdminRoleDao.deleteById(id) > 0;
    }
}
