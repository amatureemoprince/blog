package com.lj.blog.application.controller.convert;

import com.lj.blog.application.controller.dto.BlogContentDto;
import com.lj.blog.domain.entity.BlogContentItemsBo;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BlogContentItemConvert
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/18 19:02
 * @Version JDK 17
 */
@Mapper(componentModel = "spring")
public interface BlogContentItemConvert {

    default BlogContentDto blogContentBoToDto(List<BlogContentItemsBo> blogContentItemsBoList) {
        BlogContentDto dto = new BlogContentDto();
        List<String> sentences = new ArrayList<>();
        for (BlogContentItemsBo item : blogContentItemsBoList) {
            switch (item.getType()) {
                case 0:
                    sentences.add(item.getContent());
                    break;
                case 1:
                    dto.setTitle(item.getContent());
                    break;
                case 2:
                    dto.setFooter(item.getContent());
                    break;
                case 3:
                    dto.setSubtitle(item.getContent());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown type: " + item.getType());
            }
        }
        dto.setSentences(sentences);
        return dto;
    }

}
