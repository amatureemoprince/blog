package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogUser;
import com.lj.blog.infra.basic.dao.BlogUserDao;
import com.lj.blog.infra.basic.service.BlogUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户表(BlogUser)表服务实现类
 *
 * @author makejava
 * @since 2025-01-20 14:11:30
 */
@Service("blogUserService")
public class BlogUserServiceImpl implements BlogUserService {
    @Resource
    private BlogUserDao blogUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogUser queryById(Long id) {
        return this.blogUserDao.queryById(id);
    }

    @Override
    public List<BlogUser> queryPrimary(BlogUser blogUser) {
        return this.blogUserDao.queryPrimary(blogUser);
    }


    /**
     * 新增数据
     *
     * @param blogUser 实例对象
     * @return 实例对象
     */
    @Override
    public BlogUser insert(BlogUser blogUser) {
        this.blogUserDao.insert(blogUser);
        return blogUser;
    }

    /**
     * 修改数据
     *
     * @param blogUser 实例对象
     * @return 实例对象
     */
    @Override
    public BlogUser update(BlogUser blogUser) {
        this.blogUserDao.update(blogUser);
        return this.queryById(blogUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.blogUserDao.deleteById(id) > 0;
    }
}
