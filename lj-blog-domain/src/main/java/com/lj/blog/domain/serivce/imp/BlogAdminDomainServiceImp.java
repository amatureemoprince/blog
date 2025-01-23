package com.lj.blog.domain.serivce.imp;

import com.lj.blog.domain.serivce.BlogAdminDomainService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName BlogAdminDomainServiceImp
 * @Description 博客管理者服务类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/23 9:03
 * @Version JDK 17
 */
@Service
public class BlogAdminDomainServiceImp implements BlogAdminDomainService {

    @Override
    public Set<String> getPermissionListById(long l) {
        return Set.of();
    }
}
