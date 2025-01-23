package com.lj.blog.domain.serivce;

import java.util.List;
import java.util.Set;

/**
 * @ClassName BlogAdminDomainService
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/23 9:03
 * @Version JDK 17
 */
public interface BlogAdminDomainService {
    Set<String> getPermissionListById(long l);
}
