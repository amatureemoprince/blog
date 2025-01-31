package com.lj.blog.domain.handler.imp;

import com.lj.blog.domain.handler.PermissionOrRoleHandler;
import com.lj.blog.common.satoken.StpKit;
import com.lj.blog.domain.serivce.imp.BlogPermissionDomainServiceImp;
import com.lj.blog.domain.serivce.imp.BlogRoleDomainServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @ClassName UserPermissionOrRoleHandler
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/27 13:26
 * @Version JDK 17
 */
@Component
public class UserPermissionOrRoleHandler implements PermissionOrRoleHandler {

    private final BlogRoleDomainServiceImp blogRoleDomainService;
    private final BlogPermissionDomainServiceImp blogPermissionDomainService;

    @Autowired
    public UserPermissionOrRoleHandler(BlogRoleDomainServiceImp blogUserDomainService,
                                       BlogPermissionDomainServiceImp blogPermissionDomainService){
        this.blogRoleDomainService = blogUserDomainService;
        this.blogPermissionDomainService = blogPermissionDomainService;
    }

    @Override
    public String getType() {
        return StpKit.USER_ROLE;
    }

    /**
     * 获取用户权限
     * @return 用户权限
     */
    @Override
    public Set<String> getPermissionSet(Object loginId) {
        return blogPermissionDomainService.getUserPermissionSetByUserId(Integer.parseInt((String) loginId));
    }

    /**
     * 获取用户角色
     * @return 用户角色
     */
    @Override
    public Set<String> getRoleSet(Object loginId) {
        return blogRoleDomainService.getUserRoleByUserId(Integer.parseInt((String) loginId));
    }
}
