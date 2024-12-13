package com.lj.blog.application.controller.convert;

import com.lj.blog.application.controller.dto.article.tag.AddArticleTagDto;
import com.lj.blog.application.controller.dto.article.tag.ArticleTagDto;
import com.lj.blog.application.controller.dto.article.tag.UpdateArticleTagDto;
import com.lj.blog.domain.entity.ArticleTagBo;
import com.lj.blog.infra.basic.entity.ArticleTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @ClassName ArticleTagConvert
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/12 17:55
 * @Version JDK 17
 */
@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleTagConvert {
    ArticleTagBo toArticleBo(ArticleTagDto articleTagDto);
    ArticleTagBo toArticleBo(AddArticleTagDto articleTagDto);
    ArticleTagBo toArticleBo(UpdateArticleTagDto articleTagDto);
    List<ArticleTagBo> toArticleBoList(List<ArticleTagDto> articleTagDtoList);
    ArticleTagDto toArticleDto(ArticleTagBo articleTagBo);
    List<ArticleTagDto> toArticleDtoList(List<ArticleTagBo> articleTagBoList);
}
