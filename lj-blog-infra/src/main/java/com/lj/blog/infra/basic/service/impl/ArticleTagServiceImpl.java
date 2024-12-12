package com.lj.blog.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lj.blog.infra.basic.entity.ArticleTag;
import com.lj.blog.infra.basic.mapper.ArticleTagDao;
import com.lj.blog.infra.basic.service.ArticleTagService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 文章标签表(ArticleTag)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 08:17:39
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagDao, ArticleTag> implements ArticleTagService {
    @Resource
    private ArticleTagDao articleTagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleTag queryById(Integer id) {
        return this.articleTagDao.queryById(id);
    }

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
    @Override
    public int insert(ArticleTag articleTag) {
        return this.articleTagDao.insert(articleTag);
    }

    /**
     * 修改数据
     *
     * @param articleTag 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleTag update(ArticleTag articleTag) {
        this.articleTagDao.update(articleTag);
        return this.queryById(articleTag.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.articleTagDao.deleteById(id) > 0;
    }
}
