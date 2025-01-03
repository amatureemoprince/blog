package com.lj.blog.infra.basic.dao;

import com.lj.blog.infra.basic.entity.BlogContentItems;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 博客主页展示信息表(BlogContentItems)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-18 18:49:39
 */
@Mapper
public interface BlogContentItemsDao {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogContentItems queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param blogContentItems 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */


    /**
     * 统计总行数
     *
     * @param blogContentItems 查询条件
     * @return 总行数
     */
    long count(BlogContentItems blogContentItems);

    /**
     * 新增数据
     *
     * @param blogContentItems 实例对象
     * @return 影响行数
     */
    int insert(BlogContentItems blogContentItems);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogContentItems> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BlogContentItems> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BlogContentItems> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BlogContentItems> entities);

    /**
     * 修改数据
     *
     * @param blogContentItems 实例对象
     * @return 影响行数
     */
    int update(BlogContentItems blogContentItems);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    /**
     * 根据传入的对象进行查询
     * */
    List<BlogContentItems> queryPrimary(BlogContentItems blogContentItem);
}

