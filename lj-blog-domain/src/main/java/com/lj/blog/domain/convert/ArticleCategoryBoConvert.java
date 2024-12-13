package com.lj.blog.domain.convert;
import com.lj.blog.domain.entity.ArticleCategoryBo;
import com.lj.blog.infra.basic.entity.ArticleCategory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


/**
 * @ClassName ArticleCategoryBoConvert
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 20:26
 * @Version JDK 17
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleCategoryBoConvert {
    ArticleCategoryBo toBO(ArticleCategory articleCategory);
    ArticleCategory toArticleCategoryPo(ArticleCategoryBo articleCategoryBo);
    List<ArticleCategoryBo> toBOList(List<ArticleCategory> poList);
    List<ArticleCategory> toPoList(List<ArticleCategoryBo> boList);
}
