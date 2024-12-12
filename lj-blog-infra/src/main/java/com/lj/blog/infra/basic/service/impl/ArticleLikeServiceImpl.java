package com.lj.blog.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lj.blog.infra.basic.entity.ArticleLike;
import com.lj.blog.infra.basic.mapper.ArticleLikeDao;
import com.lj.blog.infra.basic.service.ArticleLikeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;



/**
 * 用户点赞表(ArticleLike)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 09:03:34
 */
@Service("articleLikeService")
public class ArticleLikeServiceImpl extends ServiceImpl<ArticleLikeDao, ArticleLike> implements ArticleLikeService {
    @Resource
    private ArticleLikeDao articleLikeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleLike queryById(Integer id) {
        return this.articleLikeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param articleLike 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param articleLike 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(ArticleLike articleLike) {
        return this.articleLikeDao.insert(articleLike);
    }

    /**
     * 修改数据
     *
     * @param articleLike 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleLike update(ArticleLike articleLike) {
        this.articleLikeDao.update(articleLike);
        return this.queryById(articleLike.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.articleLikeDao.deleteById(id) > 0;
    }
}
