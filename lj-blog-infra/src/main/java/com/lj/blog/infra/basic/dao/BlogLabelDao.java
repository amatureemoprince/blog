package com.lj.blog.infra.basic.dao;

import com.lj.blog.infra.basic.entity.BlogLabel;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * 博客标签表(BlogLabel)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-19 13:30:09
 */
public interface BlogLabelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogLabel queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param blogLabel 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */

    /**
     * 统计总行数
     *
     * @param blogLabel 查询条件
     * @return 总行数
     */
    long count(BlogLabel blogLabel);

    /**
     * 新增数据
     *
     * @param blogLabel 实例对象
     * @return 影响行数
     */
    int insert(BlogLabel blogLabel);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogLabel> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BlogLabel> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogLabel> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BlogLabel> entities);

    /**
     * 修改数据
     *
     * @param blogLabel 实例对象
     * @return 影响行数
     */
    int update(BlogLabel blogLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<BlogLabel> queryByIds(@Param("ids") Collection<Integer> labelIds);
}

