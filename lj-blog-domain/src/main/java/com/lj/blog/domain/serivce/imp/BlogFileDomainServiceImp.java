package com.lj.blog.domain.serivce.imp;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.lj.blog.common.dto.AvatarRespDto;
import com.lj.blog.common.result.Result;
import com.lj.blog.common.satoken.StpKit;
import com.lj.blog.common.utils.MinioUtils;
import com.lj.blog.domain.serivce.BlogFileDomainService;
import com.lj.blog.infra.basic.entity.BlogUser;
import com.lj.blog.infra.basic.service.impl.BlogUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName BlogFileDomainServiceImp
 * @Description 博客文件服务类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/22 18:48
 * @Version JDK 17
 */
@Service
public class BlogFileDomainServiceImp implements BlogFileDomainService {

    private final BlogUserServiceImpl blogUserService;

    private final MinioUtils minioUtils;

    @Autowired
    public BlogFileDomainServiceImp(BlogUserServiceImpl blogUserService,
                                    MinioUtils minioUtils) {
        this.blogUserService = blogUserService;
        this.minioUtils = minioUtils;
    }

    /**
     * @Description 上传用户的头像
     * @param avatar 头像
     * @return 图片url
     */
    @Override
    public Result<String> uploadUserAvatar(MultipartFile avatar) {
        AvatarRespDto avatarRespDto = minioUtils.uploadUserOrAdminAvatar(avatar, StpKit.USER_ROLE);
        BlogUser blogUser = BlogUser.builder()
                .id(Long.parseLong((String) StpKit.USER.getLoginId()))
                .avatar(avatarRespDto.getFolderLocation())
                .build();
        BlogUser update = blogUserService.update(blogUser);
        if(!ObjectUtil.isEmpty(update)){
            return Result.success(avatarRespDto.getUrl());
        }
        return Result.error("上传头像失败");
    }
}
