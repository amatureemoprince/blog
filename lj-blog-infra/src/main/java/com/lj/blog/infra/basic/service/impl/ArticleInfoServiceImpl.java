package com.lj.blog.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lj.blog.infra.basic.entity.ArticleInfo;
import com.lj.blog.infra.basic.mapper.ArticleInfoDao;
import com.lj.blog.infra.basic.service.ArticleInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 文章信息表(ArticleInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-12-10 10:34:17
 */
@Service("articleInfoService")
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoDao, ArticleInfo> implements ArticleInfoService {
    @Resource
    private ArticleInfoDao articleInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleInfo queryById(int id) {
        return this.articleInfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param articleInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param articleInfo 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(ArticleInfo articleInfo) {
        return this.articleInfoDao.insert(articleInfo);
    }

    /**
     * 修改数据
     *
     * @param articleInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleInfo update(ArticleInfo articleInfo) {
        this.articleInfoDao.update(articleInfo);
        return this.queryById(articleInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.articleInfoDao.deleteById(id) > 0;
    }
}
