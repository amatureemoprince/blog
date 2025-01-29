package com.lj.blog.domain.serivce;

import java.util.Set;

/**
 * @ClassName BlogRoleDomainService
 * @Description 博客角色服务
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/27 9:32
 * @Version JDK 17
 */
public interface BlogRoleDomainService {

    Set<String> getUserRoleByUserId(Integer id);

    Set<String> getAdminRoleByAdminId(Integer id);

}
