package com.lj.blog.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lj.blog.infra.basic.entity.ArticleCollection;
import com.lj.blog.infra.basic.mapper.ArticleCollectionDao;
import com.lj.blog.infra.basic.service.ArticleCollectionService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * 用户收藏表(ArticleCollection)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 08:33:25
 */
@Service("articleCollectionService")
public class ArticleCollectionServiceImpl extends ServiceImpl<ArticleCollectionDao, ArticleCollection> implements ArticleCollectionService {
    @Resource
    private ArticleCollectionDao articleCollectionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleCollection queryById(Integer id) {
        return this.articleCollectionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param articleCollection 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param articleCollection 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(ArticleCollection articleCollection) {
        return this.articleCollectionDao.insert(articleCollection);
    }

    /**
     * 修改数据
     *
     * @param articleCollection 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleCollection update(ArticleCollection articleCollection) {
        this.articleCollectionDao.update(articleCollection);
        return this.queryById(articleCollection.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.articleCollectionDao.deleteById(id) > 0;
    }
}
