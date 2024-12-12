package com.lj.blog.infra.basic.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lj.blog.infra.basic.entity.ArticleCategoryRel;

/**
 * 文章分类关联表(ArticleCategoryRel)表服务接口
 *
 * @author makejava
 * @since 2024-12-12 08:26:19
 */
public interface ArticleCategoryRelService extends IService<ArticleCategoryRel> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleCategoryRel queryById(Integer id);

    /**
     * 分页查询
     *
     * @param articleCategoryRel 筛选条件
     * @param pageRequest        分页对象
     * @return 查询结果
     */

    /**
     * 新增数据
     *
     * @param articleCategoryRel 实例对象
     * @return 实例对象
     */
    int insert(ArticleCategoryRel articleCategoryRel);

    /**
     * 修改数据
     *
     * @param articleCategoryRel 实例对象
     * @return 实例对象
     */
    ArticleCategoryRel update(ArticleCategoryRel articleCategoryRel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
