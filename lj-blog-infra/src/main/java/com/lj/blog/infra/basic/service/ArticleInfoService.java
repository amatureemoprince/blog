package com.lj.blog.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lj.blog.infra.basic.entity.ArticleInfo;

/**
 * 文章信息表(ArticleInfo)表服务接口
 *
 * @author makejava
 * @since 2024-12-10 10:34:17
 */
public interface ArticleInfoService extends IService<ArticleInfo> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleInfo queryById(int id);

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
    int insert(ArticleInfo articleInfo);

    /**
     * 修改数据
     *
     * @param articleInfo 实例对象
     * @return 实例对象
     */
    ArticleInfo update(ArticleInfo articleInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(int id);

}
