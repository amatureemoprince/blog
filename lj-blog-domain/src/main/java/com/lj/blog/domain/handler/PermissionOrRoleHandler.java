package com.lj.blog.domain.handler;

import java.util.Set;

/**
 * @ClassName PermissionOrRoleHandler
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/27 13:26
 * @Version JDK 17
 */
public interface PermissionOrRoleHandler {

    String getType();

    Set<String> getPermissionSet(Object loginId);

    Set<String> getRoleSet();
}
