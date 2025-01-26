package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogUserRole;
import com.lj.blog.infra.basic.dao.BlogUserRoleDao;
import com.lj.blog.infra.basic.service.BlogUserRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;


/**
 * 用户角色表(BlogUserRole)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 15:15:24
 */
@Service("blogUserRoleService")
public class BlogUserRoleServiceImpl implements BlogUserRoleService {
    @Resource
    private BlogUserRoleDao blogUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogUserRole queryById(Integer id) {
        return this.blogUserRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param blogUserRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BlogUserRole> queryByPage(BlogUserRole blogUserRole, PageRequest pageRequest) {
        long total = this.blogUserRoleDao.count(blogUserRole);
        return new PageImpl<>(this.blogUserRoleDao.queryAllByLimit(blogUserRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param blogUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public BlogUserRole insert(BlogUserRole blogUserRole) {
        this.blogUserRoleDao.insert(blogUserRole);
        return blogUserRole;
    }

    /**
     * 修改数据
     *
     * @param blogUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public BlogUserRole update(BlogUserRole blogUserRole) {
        this.blogUserRoleDao.update(blogUserRole);
        return this.queryById(blogUserRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogUserRoleDao.deleteById(id) > 0;
    }
}
