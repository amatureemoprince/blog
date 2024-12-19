package com.lj.blog.infra.basic.dao;

import com.lj.blog.infra.basic.entity.BlogArticleCategoryLabelMapping;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 文章分类标签关系表(BlogArticleCategoryLabelMapping)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-19 13:28:39
 */
public interface BlogArticleCategoryLabelMappingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogArticleCategoryLabelMapping queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param blogArticleCategoryLabelMapping 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BlogArticleCategoryLabelMapping> queryAllByLimit(BlogArticleCategoryLabelMapping blogArticleCategoryLabelMapping, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param blogArticleCategoryLabelMapping 查询条件
     * @return 总行数
     */
    long count(BlogArticleCategoryLabelMapping blogArticleCategoryLabelMapping);

    /**
     * 新增数据
     *
     * @param blogArticleCategoryLabelMapping 实例对象
     * @return 影响行数
     */
    int insert(BlogArticleCategoryLabelMapping blogArticleCategoryLabelMapping);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogArticleCategoryLabelMapping> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BlogArticleCategoryLabelMapping> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogArticleCategoryLabelMapping> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BlogArticleCategoryLabelMapping> entities);

    /**
     * 修改数据
     *
     * @param blogArticleCategoryLabelMapping 实例对象
     * @return 影响行数
     */
    int update(BlogArticleCategoryLabelMapping blogArticleCategoryLabelMapping);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

