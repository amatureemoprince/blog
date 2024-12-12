package com.lj.blog.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lj.blog.infra.basic.entity.ArticleTagRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘杰
 */
public interface ArticleTagRelDao extends BaseMapper<ArticleTagRel> {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleTagRel queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param articleTag 查询条件
     * @param pageable   分页对象
     * @return 对象列表
     */

    /**
     * 统计总行数
     *
     * @param articleTagRel 查询条件
     * @return 总行数
     */
    long count(ArticleTagRel articleTagRel);

    /**
     * 新增数据
     *
     * @param articleTagRel 实例对象
     * @return 影响行数
     */
    @Override
    int insert(ArticleTagRel articleTagRel);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleTag> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ArticleTagRel> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleTag> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ArticleTagRel> entities);

    /**
     * 修改数据
     *
     * @param articleTagRel 实例对象
     * @return 影响行数
     */
    int update(ArticleTagRel articleTagRel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


}
