package com.lj.blog.infra.basic.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lj.blog.infra.basic.entity.ArticleCollection;


/**
 * 用户收藏表(ArticleCollection)表服务接口
 *
 * @author makejava
 * @since 2024-12-12 08:33:25
 */
public interface ArticleCollectionService extends IService<ArticleCollection> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleCollection queryById(Integer id);

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
    int insert(ArticleCollection articleCollection);

    /**
     * 修改数据
     *
     * @param articleCollection 实例对象
     * @return 实例对象
     */
    ArticleCollection update(ArticleCollection articleCollection);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
