package com.lj.blog.infra.basic.dao;

import com.lj.blog.infra.basic.entity.BlogArticleStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 文章统计表(BlogArticleStatus)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-19 13:29:28
 */
@Mapper
public interface BlogArticleStatusDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogArticleStatus queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param blogArticleStatus 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */


    /**
     * 统计总行数
     *
     * @param blogArticleStatus 查询条件
     * @return 总行数
     */
    long count(BlogArticleStatus blogArticleStatus);

    /**
     * 新增数据
     *
     * @param blogArticleStatus 实例对象
     * @return 影响行数
     */
    int insert(BlogArticleStatus blogArticleStatus);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogArticleStatus> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BlogArticleStatus> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogArticleStatus> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BlogArticleStatus> entities);

    /**
     * 修改数据
     *
     * @param blogArticleStatus 实例对象
     * @return 影响行数
     */
    int update(BlogArticleStatus blogArticleStatus);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    BlogArticleStatus queryPrimary(BlogArticleStatus status);

    List<BlogArticleStatus> queryByIds(@Param("ids") List<Integer> articleIds);
}

