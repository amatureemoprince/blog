package com.lj.blog.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lj.blog.infra.basic.entity.ArticleLike;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户点赞表(ArticleLike)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-12 09:03:34
 */
public interface ArticleLikeDao extends BaseMapper<ArticleLike> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleLike queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param articleLike 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */

    /**
     * 统计总行数
     *
     * @param articleLike 查询条件
     * @return 总行数
     */
    long count(ArticleLike articleLike);

    /**
     * 新增数据
     *
     * @param articleLike 实例对象
     * @return 影响行数
     */
    @Override
    int insert(ArticleLike articleLike);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleLike> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ArticleLike> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleLike> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ArticleLike> entities);

    /**
     * 修改数据
     *
     * @param articleLike 实例对象
     * @return 影响行数
     */
    int update(ArticleLike articleLike);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

