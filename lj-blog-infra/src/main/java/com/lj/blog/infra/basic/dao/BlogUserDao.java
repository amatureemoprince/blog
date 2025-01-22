package com.lj.blog.infra.basic.dao;

import com.lj.blog.infra.basic.entity.BlogUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户表(BlogUser)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-20 14:11:30
 */
@Mapper
public interface BlogUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param blogUser 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */

    /**
     * 统计总行数
     *
     * @param blogUser 查询条件
     * @return 总行数
     */
    long count(BlogUser blogUser);

    /**
     * 新增数据
     *
     * @param blogUser 实例对象
     * @return 影响行数
     */
    int insert(BlogUser blogUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BlogUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BlogUser> entities);

    /**
     * 修改数据
     *
     * @param blogUser 实例对象
     * @return 影响行数
     */
    int update(BlogUser blogUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


    List<BlogUser> queryPrimary(BlogUser blogUser);
}

