package com.lj.blog.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lj.blog.infra.basic.entity.ArticleTagRel;
import com.lj.blog.infra.basic.mapper.ArticleTagRelDao;
import com.lj.blog.infra.basic.service.ArticleTagRelService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 文章标签关联表(ArticleTagRel)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 09:16:30
 */
@Service("articleTagRelService")
public class ArticleTagRelServiceImpl extends ServiceImpl<ArticleTagRelDao, ArticleTagRel>implements ArticleTagRelService {
    @Resource
    private ArticleTagRelDao articleTagRelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleTagRel queryById(Integer id) {
        return this.articleTagRelDao.queryById(id);
    }

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
    @Override
    public int insert(ArticleTagRel articleTagRel) {
        return this.articleTagRelDao.insert(articleTagRel);
    }

    /**
     * 修改数据
     *
     * @param articleTagRel 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleTagRel update(ArticleTagRel articleTagRel) {
        this.articleTagRelDao.update(articleTagRel);
        return this.queryById(articleTagRel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.articleTagRelDao.deleteById(id) > 0;
    }
}
