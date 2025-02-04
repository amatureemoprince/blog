package com.lj.blog.application.controller.satoken;

import cn.dev33.satoken.stp.StpInterface;
import com.lj.blog.domain.handler.PermissionOrRoleHandler;
import com.lj.blog.domain.handler.factory.PermissionOrRoleFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
/**
 * @ClassName StpInterfaceImpl
 * @Description 使用工厂模式 自定义权限加载接口实现类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/18 22:53
 * @Version JDK 17
 */
@Component
@Slf4j
public class StpInterfaceImpl implements StpInterface {


    private final PermissionOrRoleFactory permissionOrRoleFactory;

    @Autowired
    public StpInterfaceImpl(PermissionOrRoleFactory permissionOrRoleFactory){
        this.permissionOrRoleFactory = permissionOrRoleFactory;
    }

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        log.info("获取权限列表, loginId: {}, loginType: {}", loginId, loginType);
        //获取工厂
        PermissionOrRoleHandler permissionOrRoleHandler = permissionOrRoleFactory.getPermissionOrRoleHandler(loginType);
        log.info("此时得到的permissionOrRoleHandler的type为：{}", permissionOrRoleHandler.getType());
        return permissionOrRoleHandler.getPermissionSet(loginId).stream().toList();
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        log.info("获取角色列表, loginId: {}, loginType: {}", loginId, loginType);
        PermissionOrRoleHandler permissionOrRoleHandler = permissionOrRoleFactory.getPermissionOrRoleHandler(loginType);
        return permissionOrRoleHandler.getRoleSet(loginId).stream().toList();
    }
}
