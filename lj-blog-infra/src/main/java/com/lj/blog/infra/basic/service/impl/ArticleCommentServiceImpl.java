package com.lj.blog.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lj.blog.infra.basic.entity.ArticleComment;
import com.lj.blog.infra.basic.mapper.ArticleCommentDao;
import com.lj.blog.infra.basic.service.ArticleCommentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 文章评论表(ArticleComment)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 08:39:30
 */
@Service("articleCommentService")
public class ArticleCommentServiceImpl extends ServiceImpl<ArticleCommentDao, ArticleComment> implements ArticleCommentService {
    @Resource
    private ArticleCommentDao articleCommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleComment queryById(Integer id) {
        return this.articleCommentDao.queryById(id);
    }

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
    @Override
    public int insert(ArticleComment articleComment) {
        return this.articleCommentDao.insert(articleComment);
    }

    /**
     * 修改数据
     *
     * @param articleComment 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleComment update(ArticleComment articleComment) {
        this.articleCommentDao.update(articleComment);
        return this.queryById(articleComment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.articleCommentDao.deleteById(id) > 0;
    }
}
