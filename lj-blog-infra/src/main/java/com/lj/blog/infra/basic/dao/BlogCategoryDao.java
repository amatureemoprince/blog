package com.lj.blog.infra.basic.dao;

import com.lj.blog.infra.basic.entity.BlogCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * 博客分类表(BlogCategory)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-19 13:29:47
 */
@Mapper
public interface BlogCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogCategory queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param blogCategory 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */


    /**
     * 统计总行数
     *
     * @param blogCategory 查询条件
     * @return 总行数
     */
    long count(BlogCategory blogCategory);

    /**
     * 新增数据
     *
     * @param blogCategory 实例对象
     * @return 影响行数
     */
    int insert(BlogCategory blogCategory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogCategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BlogCategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogCategory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BlogCategory> entities);

    /**
     * 修改数据
     *
     * @param blogCategory 实例对象
     * @return 影响行数
     */
    int update(BlogCategory blogCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<BlogCategory> queryByIds(@Param("ids") Collection<Integer> categoryIds);
}

