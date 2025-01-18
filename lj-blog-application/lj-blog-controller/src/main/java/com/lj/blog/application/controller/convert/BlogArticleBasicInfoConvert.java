package com.lj.blog.application.controller.convert;

import com.lj.blog.application.controller.dto.BlogArticleBasicInfoDto;
import com.lj.blog.application.controller.dto.BlogArticleContentDto;
import com.lj.blog.domain.entity.BlogArticleBasicInfoBo;
import com.lj.blog.domain.entity.BlogArticleContentBo;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * @ClassName BlogArticleBasicInfoConvert
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/19 21:34
 * @Version JDK 17
 */
@Mapper(componentModel = "spring")
public interface BlogArticleBasicInfoConvert {
    BlogArticleBasicInfoDto toBlogArticleBasicInfoDto(BlogArticleBasicInfoBo bo);
    List<BlogArticleBasicInfoDto> toBlogArticleBasicInfoDtoList(List<BlogArticleBasicInfoBo> blogArticleBasicInfoBoList);
    BlogArticleContentDto toBlogArticleContentDto(BlogArticleContentBo bo);
}
