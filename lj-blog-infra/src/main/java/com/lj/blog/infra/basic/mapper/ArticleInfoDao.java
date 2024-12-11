package com.lj.blog.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lj.blog.infra.basic.entity.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章信息表(ArticleInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-10 10:34:17
 */
@Mapper
public interface ArticleInfoDao extends BaseMapper<ArticleInfo> {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleInfo queryById(int id);

    /**
     * 统计总行数
     *
     * @param articleInfo 查询条件
     * @return 总行数
     */
    long count(ArticleInfo articleInfo);

    /**
     * 新增数据
     *
     * @param articleInfo 实例对象
     * @return 影响行数
     */
    int insert(ArticleInfo articleInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ArticleInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ArticleInfo> entities);

    /**
     * 修改数据
     *
     * @param articleInfo 实例对象
     * @return 影响行数
     */
    int update(ArticleInfo articleInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(int id);

}

