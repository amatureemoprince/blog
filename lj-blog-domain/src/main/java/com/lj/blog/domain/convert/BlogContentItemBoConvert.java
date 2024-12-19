package com.lj.blog.domain.convert;

import com.lj.blog.domain.entity.BlogContentItemsBo;
import com.lj.blog.infra.basic.entity.BlogContentItems;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @ClassName BlogContentItemBoConvert
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/18 19:09
 * @Version JDK 17
 */
@Mapper(componentModel = "spring")
public interface BlogContentItemBoConvert {
    BlogContentItemsBo blogContentItemToBo(BlogContentItems blogContentItems);
    List<BlogContentItemsBo> blogContentItemToBoList(List<BlogContentItems> blogContentItems);
}
