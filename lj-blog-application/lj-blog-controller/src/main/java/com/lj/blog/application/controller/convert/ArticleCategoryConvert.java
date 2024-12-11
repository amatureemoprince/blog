package com.lj.blog.application.controller.convert;
import com.lj.blog.application.controller.dto.article.category.AddArticleCategoryDto;
import com.lj.blog.application.controller.dto.article.category.ArticleCategoryDto;
import com.lj.blog.application.controller.dto.article.category.UpdateArticleCategoryDto;
import com.lj.blog.common.enums.ArticleModuleEnum;
import com.lj.blog.domain.entity.ArticleCategoryBo;
import org.mapstruct.*;
import java.util.List;

/**
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 17:59
 * @Version JDK 17
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR,
        typeConversionPolicy = ReportingPolicy.ERROR)
public interface ArticleCategoryConvert {
    @Mappings({
            @Mapping(target = "level", expression = "java(CategoryLevelUtil.convertToLevel(articleCategoryDto.getParentId()))"),
            @Mapping(target = "id", ignore = true)
    })
    ArticleCategoryBo toArticleCategoryBo(AddArticleCategoryDto articleCategoryDto);

    @BeanMapping(ignoreUnmappedSourceProperties = "sortOrder")
    ArticleCategoryDto toDto(ArticleCategoryBo articleCategoryBo);

    @Mapping(target = "level", expression = "java(CategoryLevelUtil.convertToLevel(updateArticleCategoryDto.getParentId()))")
    ArticleCategoryBo toArticleCategoryBo(UpdateArticleCategoryDto updateArticleCategoryDto);

    List<ArticleCategoryDto> toArticleCategoryDtoList(List<ArticleCategoryBo> articleCategoryBoList);

    class CategoryLevelUtil {
        public static Integer convertToLevel(Integer parentId) {
            if (parentId == null) {
                return ArticleModuleEnum.ARTICLE_CATEGORY_TOP_SORT.getCode();
            }
            return parentId == 0 ?
                    ArticleModuleEnum.ARTICLE_CATEGORY_TOP_SORT.getCode() :
                    ArticleModuleEnum.ARTICLE_CATEGORY_BOTTOM_SORT.getCode();
        }
    }
}
