package com.lj.blog.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lj.blog.infra.basic.entity.ArticleCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章分类表(ArticleCategory)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-10 17:44:01
 */
@Mapper
public interface ArticleCategoryDao extends BaseMapper<ArticleCategory> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleCategory queryById(Integer id);


    /**
     * 统计总行数
     *
     * @param articleCategory 查询条件
     * @return 总行数
     */
    long count(ArticleCategory articleCategory);

    /**
     * 新增数据
     *
     * @param articleCategory 实例对象
     * @return 影响行数
     */

    int insertArticleCategory(ArticleCategory articleCategory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleCategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ArticleCategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ArticleCategory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ArticleCategory> entities);

    /**
     * 修改数据
     *
     * @param articleCategory 实例对象
     * @return 影响行数
     */
    ArticleCategory update(ArticleCategory articleCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    @Update("<script>" +
            "UPDATE article_category SET is_deleted = 1 " +
            "WHERE id IN " +
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int deleteBatch(List<Integer> ids);

    @Select("SELECT COUNT(*) FROM article_category " +
            "WHERE category_name = #{categoryName} " +
            "AND is_deleted = 0 " +
            "AND parent_id = #{parentId}")
    int queryByCategoryName(@Param("categoryName") String articleCategoryName,
                            @Param("parentId") Integer parentId);


    List<ArticleCategory> queryPrimary();
}

