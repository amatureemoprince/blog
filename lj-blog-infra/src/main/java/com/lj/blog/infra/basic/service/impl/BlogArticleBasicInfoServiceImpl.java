package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogArticleBasicInfo;
import com.lj.blog.infra.basic.dao.BlogArticleBasicInfoDao;
import com.lj.blog.infra.basic.service.BlogArticleBasicInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 文章基本信息表(BlogArticleBasicInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-12-19 13:28:09
 */
@Service("blogArticleBasicInfoService")
public class BlogArticleBasicInfoServiceImpl implements BlogArticleBasicInfoService {
    @Resource
    private BlogArticleBasicInfoDao blogArticleBasicInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogArticleBasicInfo queryById(Integer id) {
        return this.blogArticleBasicInfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param blogArticleBasicInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */



    /**
     * 新增数据
     *
     * @param blogArticleBasicInfo 实例对象
     * @return 实例对象
     */
    @Override
    public BlogArticleBasicInfo insert(BlogArticleBasicInfo blogArticleBasicInfo) {
        this.blogArticleBasicInfoDao.insert(blogArticleBasicInfo);
        return blogArticleBasicInfo;
    }

    /**
     * 修改数据
     *
     * @param blogArticleBasicInfo 实例对象
     * @return 实例对象
     */
    @Override
    public BlogArticleBasicInfo update(BlogArticleBasicInfo blogArticleBasicInfo) {
        this.blogArticleBasicInfoDao.update(blogArticleBasicInfo);
        return this.queryById(blogArticleBasicInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogArticleBasicInfoDao.deleteById(id) > 0;
    }
}
