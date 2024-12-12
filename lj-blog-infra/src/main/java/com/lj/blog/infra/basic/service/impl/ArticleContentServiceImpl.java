package com.lj.blog.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lj.blog.infra.basic.entity.ArticleContent;
import com.lj.blog.infra.basic.mapper.ArticleContentDao;
import com.lj.blog.infra.basic.service.ArticleContentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
/**
 * 文章内容表(ArticleContent)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 08:12:55
 */
@Service("articleContentService")
public class ArticleContentServiceImpl extends ServiceImpl<ArticleContentDao, ArticleContent> implements ArticleContentService {
    @Resource
    private ArticleContentDao articleContentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleContent queryById(Integer id) {
        return this.articleContentDao.queryById(id);
    }


    /**
     * 分页查询
     *
     * @param articleContent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */



    /**
     * 新增数据
     *
     * @param articleContent 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(ArticleContent articleContent) {
       return this.articleContentDao.insert(articleContent);
    }

    /**
     * 修改数据
     *
     * @param articleContent 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleContent update(ArticleContent articleContent) {
        this.articleContentDao.update(articleContent);
        return this.queryById(articleContent.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.articleContentDao.deleteById(id) > 0;
    }
}
