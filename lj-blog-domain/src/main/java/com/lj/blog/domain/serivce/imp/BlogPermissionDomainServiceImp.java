package com.lj.blog.domain.serivce.imp;

import com.lj.blog.domain.serivce.BlogPermissionDomainService;
import com.lj.blog.infra.basic.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

/**
 * @ClassName BlogPermissionDomainServiceImp
 * @Description 博客系统的权限服务类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/27 9:54
 * @Version JDK 17
 */
@Service
public class BlogPermissionDomainServiceImp implements BlogPermissionDomainService {

    //使用用户角色和admin角色进行查询对应的权限
    private final BlogUserRoleServiceImpl blogUserRoleService;

    private final BlogAdminRoleServiceImpl blogAdminRoleService;

    private final BlogRolePermissionServiceImpl blogRolePermissionService;

    @Autowired
    public BlogPermissionDomainServiceImp(BlogUserRoleServiceImpl blogUserRoleService,
                                          BlogAdminRoleServiceImpl blogAdminRoleService,
                                          BlogRolePermissionServiceImpl blogRolePermissionService){
        this.blogUserRoleService = blogUserRoleService;
        this.blogAdminRoleService = blogAdminRoleService;
        this.blogRolePermissionService = blogRolePermissionService;
    }

    @Transactional
    @Override
    public Set<String> getUserPermissionSetByUserId(Integer userId) {
        Set<String> roleSet = blogUserRoleService.getRoleSetByUserId(userId);
        return getFinallyPermissionSet(roleSet);
    }

    @Transactional
    @Override
    public Set<String> getAdminPermissionSetByAdminId(Integer adminId) {
        Set<String> roleSet = blogAdminRoleService.getRoleSetByAdminId(adminId);
        return getFinallyPermissionSet(roleSet);
    }




    private Set<String> getFinallyPermissionSet(Set<String> roleSet){
        return blogRolePermissionService.getPermissionSetByRole(roleSet);
    }
}
