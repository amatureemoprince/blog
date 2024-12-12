package com.lj.blog.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lj.blog.infra.basic.entity.ArticleContent;

/**
 * 文章内容表(ArticleContent)表服务接口
 *
 * @author makejava
 * @since 2024-12-12 08:12:55
 */
public interface ArticleContentService extends IService<ArticleContent> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleContent queryById(Integer id);

    /**
     * 分页查询
     *
     * @param articleContent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */



    /**
     * 新增数据
     *
     * @param articleContent 实例对象
     * @return 实例对象
     */
    int insert(ArticleContent articleContent);

    /**
     * 修改数据
     *
     * @param articleContent 实例对象
     * @return 实例对象
     */
    ArticleContent update(ArticleContent articleContent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
