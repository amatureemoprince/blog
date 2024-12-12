package com.lj.blog.infra.basic.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lj.blog.infra.basic.entity.ArticleCategory;

import java.util.List;

/**
 * 文章分类表(ArticleCategory)表服务接口
 *
 * @author makejava
 * @since 2024-12-10 17:44:02
 */
public interface ArticleCategoryService extends IService<ArticleCategory> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleCategory queryById(Integer id);

    /**
     * 分页查询
     *
     * @param articleCategory 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    /**
     * 根据categoryName去查询是否存在
     * */
    int queryByCategoryName(String articleCategory, Integer parentId);

    /**
     * 新增数据
     *
     * @param articleCategory 实例对象
     * @return 实例对象
     */
    int insert(ArticleCategory articleCategory);

    /**
     * 修改数据
     *
     * @param articleCategory 实例对象
     * @return 实例对象
     */
    int update(ArticleCategory articleCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    int deleteBatch(List<Integer> ids);
    long count(ArticleCategory articleCategory);

    List<ArticleCategory> queryPrimary();
}
