package com.lj.blog.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lj.blog.infra.basic.entity.ArticleTag;

import java.util.List;


/**
 * 文章标签表(ArticleTag)表服务接口
 *
 * @author makejava
 * @since 2024-12-12 08:17:39
 */
public interface ArticleTagService extends IService<ArticleTag> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleTag queryById(Integer id);

    /**
     * 分页查询
     *
     * @param articleTag  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */

    /**
     * 新增数据
     *
     * @param articleTag 实例对象
     * @return 实例对象
     */
    int insert(ArticleTag articleTag);

    /**
     * 修改数据
     *
     * @param articleTag 实例对象
     * @return 实例对象
     */
    ArticleTag update(ArticleTag articleTag);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<ArticleTag> queryPrimary(ArticleTag articleTag);
    long counts(ArticleTag articleTag);

    int deleteByIds(List<Integer> ids);
}
