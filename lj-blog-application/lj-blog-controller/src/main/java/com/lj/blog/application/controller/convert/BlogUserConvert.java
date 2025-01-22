package com.lj.blog.application.controller.convert;

import com.lj.blog.application.controller.dto.BlogUserInfoRspDto;
import com.lj.blog.application.controller.dto.BlogUserLoginDto;
import com.lj.blog.application.controller.dto.BlogUserRegisterDto;
import com.lj.blog.domain.entity.BlogUserInfoRspBo;
import com.lj.blog.domain.entity.BlogUserLoginBo;
import com.lj.blog.infra.basic.entity.BlogUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Date;

/**
 * @ClassName BlogUserConvert
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/20 14:41
 * @Version JDK 17
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogUserConvert {

    default BlogUser blogRegisterDtoToBlogUser(BlogUserRegisterDto blogUserRegisterDto){
        BlogUser blogUser = new BlogUser();
        blogUser.setNickName(blogUserRegisterDto.getNickName());
        blogUser.setSex(blogUserRegisterDto.getSex());
        blogUser.setEmail(blogUserRegisterDto.getEmail());
        blogUser.setPassword(blogUserRegisterDto.getPassword());
        blogUser.setCreateTime(new Date());
        blogUser.setUpdateTime(new Date());
        blogUser.setIsDeleted(0);
        return blogUser;
    }

    BlogUserLoginBo blogUserLoginDtoToBo(BlogUserLoginDto blogUserLoginDto);

    BlogUserInfoRspDto blogUserInfoRspBoToDto(BlogUserInfoRspBo blogUserInfoRspBo);
}
