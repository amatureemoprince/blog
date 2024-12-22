package com.lj.blog.domain.convert;
import com.lj.blog.domain.entity.BlogArticleBasicInfoBo;
import com.lj.blog.domain.entity.BlogArticleContentBo;
import com.lj.blog.infra.basic.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/**
 * @ClassName BlogArticleInfoBoConvert
 * @Description 转化为相应的主页展示的bo
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/19 18:23
 * @Version JDK 17
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogArticleInfoBoConvert {
    @Mapping(target = "id", source = "blogArticleBasicInfo.id")
    @Mapping(target = "createTime", source = "blogArticleBasicInfo.createTime")
    @Mapping(target = "category", source = "blogCategory.category")
    @Mapping(target = "labels", source = "blogLabels", qualifiedByName = "toStringList")
    @Mapping(target = "likes", source = "blogArticleStatus.likes")
    @Mapping(target = "views", source = "blogArticleStatus.views")
    @Mapping(target = "comments", source = "blogArticleStatus.comments")
    @Mapping(target = "collections", source = "blogArticleStatus.collections")
    BlogArticleBasicInfoBo toBlogArticleBasicInfoConvertBo(
            BlogArticleBasicInfo blogArticleBasicInfo,
            BlogCategory blogCategory,
            List<BlogLabel> blogLabels,
            BlogArticleStatus blogArticleStatus);
//    @Named("formatDate")
//    default String formatDate(Date date) {
//        if (date == null) {
//            return null;
//        }
//        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
//    }
    @Named("toStringList")
    default List<String> toStringList(List<BlogLabel> blogLabels) {
        if (blogLabels == null) {
            return List.of();
        }
        return blogLabels.stream()
                .filter(Objects::nonNull)
                .map(BlogLabel::getLabel)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    BlogArticleContentBo toBlogArticleContentBo(BlogArticleContent blogArticleContent);
}
