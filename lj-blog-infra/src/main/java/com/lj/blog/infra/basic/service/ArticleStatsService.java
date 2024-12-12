package com.lj.blog.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lj.blog.infra.basic.entity.ArticleStats;

/**
 * 文章统计表(ArticleStats)表服务接口
 *
 * @author makejava
 * @since 2024-12-12 09:08:01
 */
public interface ArticleStatsService extends IService<ArticleStats> {

    /**
     * 通过ID查询单条数据
     *
     * @param articleId 主键
     * @return 实例对象
     */
    ArticleStats queryById(Integer articleId);

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
    int insert(ArticleStats articleStats);

    /**
     * 修改数据
     *
     * @param articleStats 实例对象
     * @return 实例对象
     */
    ArticleStats update(ArticleStats articleStats);

    /**
     * 通过主键删除数据
     *
     * @param articleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer articleId);

}
