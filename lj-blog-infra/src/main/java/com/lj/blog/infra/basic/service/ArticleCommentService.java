package com.lj.blog.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lj.blog.infra.basic.entity.ArticleComment;

/**
 * 文章评论表(ArticleComment)表服务接口
 *
 * @author makejava
 * @since 2024-12-12 08:39:30
 */
public interface ArticleCommentService extends IService<ArticleComment> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleComment queryById(Integer id);

    /**
     * 分页查询
     *
     * @param articleComment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */

    /**
     * 新增数据
     *
     * @param articleComment 实例对象
     * @return 实例对象
     */
    int insert(ArticleComment articleComment);

    /**
     * 修改数据
     *
     * @param articleComment 实例对象
     * @return 实例对象
     */
    ArticleComment update(ArticleComment articleComment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
