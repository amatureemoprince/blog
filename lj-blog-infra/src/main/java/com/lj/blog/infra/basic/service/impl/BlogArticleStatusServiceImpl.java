package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogArticleStatus;
import com.lj.blog.infra.basic.dao.BlogArticleStatusDao;
import com.lj.blog.infra.basic.service.BlogArticleStatusService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 文章统计表(BlogArticleStatus)表服务实现类
 *
 * @author makejava
 * @since 2024-12-19 13:29:28
 */
@Service("blogArticleStatusService")
public class BlogArticleStatusServiceImpl implements BlogArticleStatusService {
    @Resource
    private BlogArticleStatusDao blogArticleStatusDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogArticleStatus queryById(Integer id) {
        return this.blogArticleStatusDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param blogArticleStatus 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param blogArticleStatus 实例对象
     * @return 实例对象
     */
    @Override
    public BlogArticleStatus insert(BlogArticleStatus blogArticleStatus) {
        this.blogArticleStatusDao.insert(blogArticleStatus);
        return blogArticleStatus;
    }

    /**
     * 修改数据
     *
     * @param blogArticleStatus 实例对象
     * @return 实例对象
     */
    @Override
    public BlogArticleStatus update(BlogArticleStatus blogArticleStatus) {
        this.blogArticleStatusDao.update(blogArticleStatus);
        return this.queryById(blogArticleStatus.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogArticleStatusDao.deleteById(id) > 0;
    }
}
