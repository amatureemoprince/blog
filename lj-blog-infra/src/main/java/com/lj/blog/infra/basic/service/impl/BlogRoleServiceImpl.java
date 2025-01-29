package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogRole;
import com.lj.blog.infra.basic.dao.BlogRoleDao;
import com.lj.blog.infra.basic.service.BlogRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Set;


/**
 * 博客角色表(BlogRole)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 18:17:10
 */
@Service("blogRoleService")
public class BlogRoleServiceImpl implements BlogRoleService {
    @Resource
    private BlogRoleDao blogRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogRole queryById(Integer id) {
        return this.blogRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param blogRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BlogRole> queryByPage(BlogRole blogRole, PageRequest pageRequest) {
        long total = this.blogRoleDao.count(blogRole);
        return new PageImpl<>(this.blogRoleDao.queryAllByLimit(blogRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param blogRole 实例对象
     * @return 实例对象
     */
    @Override
    public BlogRole insert(BlogRole blogRole) {
        this.blogRoleDao.insert(blogRole);
        return blogRole;
    }

    /**
     * 修改数据
     *
     * @param blogRole 实例对象
     * @return 实例对象
     */
    @Override
    public BlogRole update(BlogRole blogRole) {
        this.blogRoleDao.update(blogRole);
        return this.queryById(blogRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogRoleDao.deleteById(id) > 0;
    }

}
