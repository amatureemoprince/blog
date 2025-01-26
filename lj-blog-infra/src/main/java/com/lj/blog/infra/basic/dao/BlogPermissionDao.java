package com.lj.blog.infra.basic.dao;

import com.lj.blog.infra.basic.entity.BlogPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 博客权限表(BlogPermission)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-26 18:22:12
 */
public interface BlogPermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogPermission queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param blogPermission 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BlogPermission> queryAllByLimit(BlogPermission blogPermission, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param blogPermission 查询条件
     * @return 总行数
     */
    long count(BlogPermission blogPermission);

    /**
     * 新增数据
     *
     * @param blogPermission 实例对象
     * @return 影响行数
     */
    int insert(BlogPermission blogPermission);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogPermission> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BlogPermission> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogPermission> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BlogPermission> entities);

    /**
     * 修改数据
     *
     * @param blogPermission 实例对象
     * @return 影响行数
     */
    int update(BlogPermission blogPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

