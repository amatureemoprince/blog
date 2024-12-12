package com.lj.blog.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lj.blog.infra.basic.entity.ArticleStats;
import com.lj.blog.infra.basic.mapper.ArticleStatsDao;
import com.lj.blog.infra.basic.service.ArticleStatsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 文章统计表(ArticleStats)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 09:08:01
 */
@Service("articleStatsService")
public class ArticleStatsServiceImpl extends ServiceImpl<ArticleStatsDao, ArticleStats> implements ArticleStatsService {
    @Resource
    private ArticleStatsDao articleStatsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param articleId 主键
     * @return 实例对象
     */
    @Override
    public ArticleStats queryById(Integer articleId) {
        return this.articleStatsDao.queryById(articleId);
    }

    /**
     * 分页查询
     *
     * @param articleStats 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param articleStats 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(ArticleStats articleStats) {
        return this.articleStatsDao.insert(articleStats);
    }

    /**
     * 修改数据
     *
     * @param articleStats 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleStats update(ArticleStats articleStats) {
        this.articleStatsDao.update(articleStats);
        return this.queryById(articleStats.getArticleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param articleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer articleId) {
        return this.articleStatsDao.deleteById(articleId) > 0;
    }
}
