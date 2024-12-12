package com.lj.blog.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lj.blog.infra.basic.entity.ArticleTagRel;

/**
 * 文章标签关联表(ArticleTagRel)表服务接口
 *
 * @author makejava
 * @since 2024-12-12 09:16:30
 */
public interface ArticleTagRelService extends IService<ArticleTagRel> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleTagRel queryById(Integer id);

    /**
     * 分页查询
     *
     * @param articleTagRel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */

    /**
     * 新增数据
     *
     * @param articleTagRel 实例对象
     * @return 实例对象
     */
    int insert(ArticleTagRel articleTagRel);

    /**
     * 修改数据
     *
     * @param articleTagRel 实例对象
     * @return 实例对象
     */
    ArticleTagRel update(ArticleTagRel articleTagRel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
