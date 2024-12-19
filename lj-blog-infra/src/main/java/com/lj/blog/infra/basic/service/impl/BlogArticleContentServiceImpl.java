package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogArticleContent;
import com.lj.blog.infra.basic.dao.BlogArticleContentDao;
import com.lj.blog.infra.basic.service.BlogArticleContentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 文章内容表(BlogArticleContent)表服务实现类
 *
 * @author makejava
 * @since 2024-12-19 13:29:00
 */
@Service("blogArticleContentService")
public class BlogArticleContentServiceImpl implements BlogArticleContentService {
    @Resource
    private BlogArticleContentDao blogArticleContentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogArticleContent queryById(Integer id) {
        return this.blogArticleContentDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param blogArticleContent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param blogArticleContent 实例对象
     * @return 实例对象
     */
    @Override
    public BlogArticleContent insert(BlogArticleContent blogArticleContent) {
        this.blogArticleContentDao.insert(blogArticleContent);
        return blogArticleContent;
    }

    /**
     * 修改数据
     *
     * @param blogArticleContent 实例对象
     * @return 实例对象
     */
    @Override
    public BlogArticleContent update(BlogArticleContent blogArticleContent) {
        this.blogArticleContentDao.update(blogArticleContent);
        return this.queryById(blogArticleContent.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogArticleContentDao.deleteById(id) > 0;
    }
}
