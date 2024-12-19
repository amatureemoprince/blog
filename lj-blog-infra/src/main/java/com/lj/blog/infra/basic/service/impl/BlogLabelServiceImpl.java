package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogLabel;
import com.lj.blog.infra.basic.dao.BlogLabelDao;
import com.lj.blog.infra.basic.service.BlogLabelService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 博客标签表(BlogLabel)表服务实现类
 *
 * @author makejava
 * @since 2024-12-19 13:30:09
 */
@Service("blogLabelService")
public class BlogLabelServiceImpl implements BlogLabelService {
    @Resource
    private BlogLabelDao blogLabelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogLabel queryById(Integer id) {
        return this.blogLabelDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param blogLabel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param blogLabel 实例对象
     * @return 实例对象
     */
    @Override
    public BlogLabel insert(BlogLabel blogLabel) {
        this.blogLabelDao.insert(blogLabel);
        return blogLabel;
    }

    /**
     * 修改数据
     *
     * @param blogLabel 实例对象
     * @return 实例对象
     */
    @Override
    public BlogLabel update(BlogLabel blogLabel) {
        this.blogLabelDao.update(blogLabel);
        return this.queryById(blogLabel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogLabelDao.deleteById(id) > 0;
    }
}
