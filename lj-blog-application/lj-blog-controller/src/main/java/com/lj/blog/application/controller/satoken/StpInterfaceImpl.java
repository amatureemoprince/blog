package com.lj.blog.application.controller.satoken;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.collection.CollectionUtil;
import com.lj.blog.common.exception.exceptions.BusinessException;
import com.lj.blog.common.satoken.StpKit;
import com.lj.blog.domain.serivce.imp.BlogAdminDomainServiceImp;
import com.lj.blog.domain.serivce.imp.BlogUserDomainServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ClassName StpInterfaceImpl
 * @Description 自定义权限加载接口实现类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/18 22:53
 * @Version JDK 17
 */
@Component
@Slf4j
public class StpInterfaceImpl implements StpInterface {

    private final BlogUserDomainServiceImp blogUserDomainService;

    private final BlogAdminDomainServiceImp blogAdminDomainService;

    @Autowired
    public StpInterfaceImpl(BlogUserDomainServiceImp blogUserDomainService,
                            BlogAdminDomainServiceImp blogAdminDomainService){
        this.blogUserDomainService = blogUserDomainService;
        this.blogAdminDomainService = blogAdminDomainService;
    }

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        log.info("获取权限列表，loginId: {}, loginType: {}", loginId, loginType);
        String id = (String) StpKit.USER.getLoginId();
        Set<String> permissionSet;
        List<String> permissionList;
        if(StpKit.USER_ROLE.equals(loginType)){
            permissionSet = blogUserDomainService.getPermissionListById(Long.parseLong(id));
            permissionList = new ArrayList<>(permissionSet);
            if(CollectionUtil.isEmpty(permissionList)){
                throw new BusinessException("该用户没有权限");
            }
            return permissionList;
        }
        //这里就是管理者权限查询
        permissionSet = blogAdminDomainService.getPermissionListById(Long.parseLong(id));
        permissionList = new ArrayList<>(permissionSet);
        if(CollectionUtil.isEmpty(permissionList)){
            throw new BusinessException("该管理者没有权限");
        }
        return permissionList;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> list = new ArrayList<String>();
        list.add("admin");
        list.add("super-admin");
        return list;
    }
}
