package com.lj.blog.infra.basic.service.impl;

import com.lj.blog.infra.basic.entity.ArticleCategory;
import com.lj.blog.infra.basic.mapper.ArticleCategoryDao;
import com.lj.blog.infra.basic.service.ArticleCategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章分类表(ArticleCategory)表服务实现类
 *
 * @author makejava
 * @since 2024-12-10 17:44:02
 */
@Service("articleCategoryService")
public class ArticleCategoryServiceImpl implements ArticleCategoryService {
    @Resource
    private ArticleCategoryDao articleCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleCategory queryById(Integer id) {
        return this.articleCategoryDao.queryById(id);
    }

    @Override
    public int queryByCategoryName(String articleCategoryName, Integer parentId){
        return this.articleCategoryDao.queryByCategoryName(articleCategoryName, parentId);
    }

    /**
     * 分页查询
     *
     * @param articleCategory 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param articleCategory 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleCategory insert(ArticleCategory articleCategory) {
        this.articleCategoryDao.insertArticleCategory(articleCategory);
        return articleCategory;
    }

    /**
     * 修改数据
     *
     * @param articleCategory 实例对象
     * @return 实例对象
     */
    @Override
    public int update(ArticleCategory articleCategory) {
        return this.articleCategoryDao.update(articleCategory);

    }




    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.articleCategoryDao.deleteById(id) > 0;
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return this.articleCategoryDao.deleteBatch(ids);
    }

    @Override
    public long count(ArticleCategory articleCategory) {
        return this.articleCategoryDao.count(articleCategory);
    }

    @Override
    public List<ArticleCategory> queryPrimary() {
        return this.articleCategoryDao.queryPrimary();
    }


}
