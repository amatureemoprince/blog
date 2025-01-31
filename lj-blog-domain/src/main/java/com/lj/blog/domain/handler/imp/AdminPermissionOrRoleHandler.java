package com.lj.blog.domain.handler.imp;

import com.lj.blog.domain.handler.PermissionOrRoleHandler;
import com.lj.blog.common.satoken.StpKit;
import com.lj.blog.domain.serivce.imp.BlogPermissionDomainServiceImp;
import com.lj.blog.domain.serivce.imp.BlogRoleDomainServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @ClassName AdminPermissionOrRoleHandler
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/27 13:27
 * @Version JDK 17
 */
@Component
public class AdminPermissionOrRoleHandler implements PermissionOrRoleHandler {

    private final BlogRoleDomainServiceImp blogRoleDomainService;

    private final BlogPermissionDomainServiceImp blogPermissionDomainService;
    @Autowired
    public AdminPermissionOrRoleHandler(BlogRoleDomainServiceImp blogUserDomainService,
                                       BlogPermissionDomainServiceImp blogPermissionDomainService){
        this.blogRoleDomainService = blogUserDomainService;
        this.blogPermissionDomainService = blogPermissionDomainService;
    }


    @Override
    public String getType() {
        return StpKit.ADMIN_ROLE;
    }

    @Override
    public Set<String> getPermissionSet(Object loginId) {
        return blogPermissionDomainService.getAdminPermissionSetByAdminId(Integer.parseInt((String) loginId));
    }

    @Override
    public Set<String> getRoleSet(Object loginId) {
        return blogRoleDomainService.getAdminRoleByAdminId(Integer.parseInt((String) loginId));
    }
}
