package com.lj.blog.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lj.blog.infra.basic.entity.ArticleLike;

/**
 * 用户点赞表(ArticleLike)表服务接口
 *
 * @author makejava
 * @since 2024-12-12 09:03:34
 */
public interface ArticleLikeService extends IService<ArticleLike> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleLike queryById(Integer id);

    /**
     * 分页查询
     *
     * @param articleLike 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */

    /**
     * 新增数据
     *
     * @param articleLike 实例对象
     * @return 实例对象
     */
    int insert(ArticleLike articleLike);

    /**
     * 修改数据
     *
     * @param articleLike 实例对象
     * @return 实例对象
     */
    ArticleLike update(ArticleLike articleLike);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
