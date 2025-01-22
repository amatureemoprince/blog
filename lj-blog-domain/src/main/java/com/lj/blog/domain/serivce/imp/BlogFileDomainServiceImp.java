package com.lj.blog.domain.serivce.imp;

import com.lj.blog.common.result.Result;
import com.lj.blog.domain.serivce.BlogFileDomainService;
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
    @Override
    public Result<String> uploadAvatar(MultipartFile avatar) {
        return null;
    }
}
