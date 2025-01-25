package com.lj.blog.domain.serivce;

import com.lj.blog.common.result.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName BlogFileDomainService
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/22 18:47
 * @Version JDK 17
 */
public interface BlogFileDomainService {
    Result<String> uploadUserAvatar(MultipartFile avatar);
}

