package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.BlogContentItems;
import com.lj.blog.infra.basic.dao.BlogContentItemsDao;
import com.lj.blog.infra.basic.service.BlogContentItemsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 博客主页展示信息表(BlogContentItems)表服务实现类
 *
 * @author makejava
 * @since 2024-12-18 18:49:44
 */
@Service("blogContentItemsService")
public class BlogContentItemsServiceImpl implements BlogContentItemsService {
    @Resource
    private BlogContentItemsDao blogContentItemsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogContentItems queryById(Integer id) {
        return this.blogContentItemsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param blogContentItems 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param blogContentItems 实例对象
     * @return 实例对象
     */
    @Override
    public BlogContentItems insert(BlogContentItems blogContentItems) {
        this.blogContentItemsDao.insert(blogContentItems);
        return blogContentItems;
    }

    /**
     * 修改数据
     *
     * @param blogContentItems 实例对象
     * @return 实例对象
     */
    @Override
    public BlogContentItems update(BlogContentItems blogContentItems) {
        this.blogContentItemsDao.update(blogContentItems);
        return this.queryById(blogContentItems.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogContentItemsDao.deleteById(id) > 0;
    }

    @Override
    public List<BlogContentItems> queryPrimary(BlogContentItems blogContentItem) {
        return this.blogContentItemsDao.queryPrimary(blogContentItem);
    }
}
