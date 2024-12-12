package com.lj.blog.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lj.blog.infra.basic.entity.ArticleCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户收藏表(ArticleCollection)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-12 08:33:25
 */
@Mapper
public interface ArticleCollectionDao extends BaseMapper<ArticleCollection> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleCollection queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param articleCollection 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */

    /**
     * 统计总行数
     *
     * @param articleCollection 查询条件
     * @return 总行数
     */
    long count(ArticleCollection articleCollection);

    /**
     * 新增数据
     *
     * @param articleCollection 实例对象
     * @return 影响行数
     */
    @Override
    int insert(ArticleCollection articleCollection);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleCollection> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ArticleCollection> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleCollection> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ArticleCollection> entities);

    /**
     * 修改数据
     *
     * @param articleCollection 实例对象
     * @return 影响行数
     */
    int update(ArticleCollection articleCollection);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

