package com.lj.blog.domain.serivce;

import java.util.Set;

/**
 * @ClassName BlogPermissionDomainService
 * @Description 博客系统获取权限服务类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/27 9:53
 * @Version JDK 17
 */
public interface BlogPermissionDomainService {

    Set<String> getUserPermissionSetByUserId(Integer userId);

    Set<String> getAdminPermissionSetByAdminId(Integer adminId);


}
