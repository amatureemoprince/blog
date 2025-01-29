package com.lj.blog.infra.basic.dao;

import com.lj.blog.infra.basic.entity.BlogAdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

/**
 * 博客管理员角色表(BlogAdminRole)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-26 18:28:14
 */
@Mapper
public interface BlogAdminRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogAdminRole queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param blogAdminRole 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BlogAdminRole> queryAllByLimit(BlogAdminRole blogAdminRole, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param blogAdminRole 查询条件
     * @return 总行数
     */
    long count(BlogAdminRole blogAdminRole);

    /**
     * 新增数据
     *
     * @param blogAdminRole 实例对象
     * @return 影响行数
     */
    int insert(BlogAdminRole blogAdminRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogAdminRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BlogAdminRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogAdminRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BlogAdminRole> entities);

    /**
     * 修改数据
     *
     * @param blogAdminRole 实例对象
     * @return 影响行数
     */
    int update(BlogAdminRole blogAdminRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Set<String> queryRolesByAdminId(Integer adminId);
}

