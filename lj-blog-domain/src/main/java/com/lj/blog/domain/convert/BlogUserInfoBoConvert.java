package com.lj.blog.domain.convert;

import com.lj.blog.domain.entity.BlogUserInfoRspBo;
import com.lj.blog.infra.basic.entity.BlogUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @ClassName BlogUserInfoBoConvert
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/22 9:59
 * @Version JDK 17
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogUserInfoBoConvert {

    BlogUserInfoRspBo blogUserInfoToBo(BlogUser blogUser);

}
