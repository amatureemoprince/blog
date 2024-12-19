package com.lj.blog.infra.basic.dao;

import com.lj.blog.infra.basic.entity.BlogArticleContent;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 文章内容表(BlogArticleContent)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-19 13:29:00
 */
public interface BlogArticleContentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogArticleContent queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param blogArticleContent 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BlogArticleContent> queryAllByLimit(BlogArticleContent blogArticleContent, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param blogArticleContent 查询条件
     * @return 总行数
     */
    long count(BlogArticleContent blogArticleContent);

    /**
     * 新增数据
     *
     * @param blogArticleContent 实例对象
     * @return 影响行数
     */
    int insert(BlogArticleContent blogArticleContent);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogArticleContent> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BlogArticleContent> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogArticleContent> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BlogArticleContent> entities);

    /**
     * 修改数据
     *
     * @param blogArticleContent 实例对象
     * @return 影响行数
     */
    int update(BlogArticleContent blogArticleContent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

