package com.lj.blog.domain.convert;

import com.lj.blog.domain.entity.ArticleTagBo;
import com.lj.blog.infra.basic.entity.ArticleTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;;
import java.util.List;
/**
 * @ClassName ArticleTagBoConvert
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/12 18:35
 * @Version JDK 17
 */
@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleTagBoConvert {
    ArticleTagBo toArticleTagBo(ArticleTag articleTag);
    List<ArticleTagBo> toArticleTagBoList(List<ArticleTag> articleTags);

    ArticleTag toArticleTagPo(ArticleTagBo articleTagBo);
}
