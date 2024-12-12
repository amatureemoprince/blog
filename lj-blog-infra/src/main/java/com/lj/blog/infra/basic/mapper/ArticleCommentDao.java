package com.lj.blog.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lj.blog.infra.basic.entity.ArticleComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 文章评论表(ArticleComment)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-12 08:39:30
 */
@Mapper
public interface ArticleCommentDao extends BaseMapper<ArticleComment> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleComment queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param articleComment 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */

    /**
     * 统计总行数
     *
     * @param articleComment 查询条件
     * @return 总行数
     */
    long count(ArticleComment articleComment);

    /**
     * 新增数据
     *
     * @param articleComment 实例对象
     * @return 影响行数
     */
    @Override
    int insert(ArticleComment articleComment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleComment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ArticleComment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleComment> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ArticleComment> entities);

    /**
     * 修改数据
     *
     * @param articleComment 实例对象
     * @return 影响行数
     */
    int update(ArticleComment articleComment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

