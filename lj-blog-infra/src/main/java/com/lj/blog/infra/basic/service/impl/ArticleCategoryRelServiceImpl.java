package com.lj.blog.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lj.blog.infra.basic.entity.ArticleCategoryRel;
import com.lj.blog.infra.basic.mapper.ArticleCategoryRelDao;
import com.lj.blog.infra.basic.service.ArticleCategoryRelService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 文章分类关联表(ArticleCategoryRel)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 08:26:19
 */
@Service("articleCategoryRelService")
public class ArticleCategoryRelServiceImpl extends ServiceImpl<ArticleCategoryRelDao, ArticleCategoryRel> implements ArticleCategoryRelService {
    @Resource
    private ArticleCategoryRelDao articleCategoryRelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleCategoryRel queryById(Integer id) {
        return this.articleCategoryRelDao.queryById(id);
    }

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
    @Override
    public int insert(ArticleCategoryRel articleCategoryRel) {
        return this.articleCategoryRelDao.insert(articleCategoryRel);
    }

    /**
     * 修改数据
     *
     * @param articleCategoryRel 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleCategoryRel update(ArticleCategoryRel articleCategoryRel) {
        this.articleCategoryRelDao.update(articleCategoryRel);
        return this.queryById(articleCategoryRel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.articleCategoryRelDao.deleteById(id) > 0;
    }
}
