package com.lj.blog.domain.serivce.imp;

import com.lj.blog.domain.serivce.BlogRoleDomainService;
import com.lj.blog.infra.basic.service.impl.BlogAdminRoleServiceImpl;
import com.lj.blog.infra.basic.service.impl.BlogRoleServiceImpl;
import com.lj.blog.infra.basic.service.impl.BlogUserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName BlogRoleDomainServiceImp
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/27 9:33
 * @Version JDK 17
 */
@Service
public class BlogRoleDomainServiceImp implements BlogRoleDomainService {

    private final BlogUserRoleServiceImpl blogUserRoleService;

    private final BlogAdminRoleServiceImpl blogAdminRoleService;

    @Autowired
    public BlogRoleDomainServiceImp(BlogUserRoleServiceImpl blogUserRoleService,
                                    BlogAdminRoleServiceImpl blogAdminRoleService) {
        this.blogUserRoleService = blogUserRoleService;
        this.blogAdminRoleService = blogAdminRoleService;
    }

    /**
     * @param userId 用户id
     * @return 角色集合
     */
    @Override
    public Set<String> getUserRoleByUserId(Integer userId) {
        return blogUserRoleService.getRoleSetByUserId(userId);
    }

    @Override
    public Set<String> getAdminRoleByAdminId(Integer adminId) {
        return blogAdminRoleService.getRoleSetByAdminId(adminId);
    }


}
