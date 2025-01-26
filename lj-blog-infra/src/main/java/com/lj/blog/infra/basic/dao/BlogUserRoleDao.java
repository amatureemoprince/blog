package com.lj.blog.infra.basic.dao;

import com.lj.blog.infra.basic.entity.BlogUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 用户角色表(BlogUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-26 15:15:24
 */
@Mapper
public interface BlogUserRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogUserRole queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param blogUserRole 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BlogUserRole> queryAllByLimit(BlogUserRole blogUserRole, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param blogUserRole 查询条件
     * @return 总行数
     */
    long count(BlogUserRole blogUserRole);

    /**
     * 新增数据
     *
     * @param blogUserRole 实例对象
     * @return 影响行数
     */
    int insert(BlogUserRole blogUserRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogUserRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BlogUserRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogUserRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BlogUserRole> entities);

    /**
     * 修改数据
     *
     * @param blogUserRole 实例对象
     * @return 影响行数
     */
    int update(BlogUserRole blogUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

