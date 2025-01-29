package com.lj.blog.domain.handler.factory;

import cn.hutool.core.collection.CollectionUtil;
import com.lj.blog.domain.handler.PermissionOrRoleHandler;
import com.lj.blog.common.utils.LogUtils;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PermissionOrRoleFactory
 * @Description 获取角色或权限的工厂
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/27 13:34
 */
@Component
@Slf4j
public class PermissionOrRoleFactory {

    private final Map<String, PermissionOrRoleHandler> permissionOrRoleHandlerMap = new HashMap<>();
    // 注入所有 handler
    private final List<PermissionOrRoleHandler> permissionOrRoleHandlerList;

    @Autowired
    public PermissionOrRoleFactory(List<PermissionOrRoleHandler> permissionOrRoleHandlerList) {
        this.permissionOrRoleHandlerList = permissionOrRoleHandlerList;
    }

    public PermissionOrRoleHandler getPermissionOrRoleHandler(String type) {
        PermissionOrRoleHandler handler = permissionOrRoleHandlerMap.get(type);
        if (handler == null) {
            LogUtils.yellow("装配的PermissionOrRoleFactory为空");
        }
        return handler;
    }

    @PostConstruct
    public void init() {
        log.info("装配 PermissionOrRoleFactory 工厂咯");
        for (PermissionOrRoleHandler handler : permissionOrRoleHandlerList) {
            String key = handler.getType();
            permissionOrRoleHandlerMap.put(key, handler);
        }
        if (CollectionUtil.isEmpty(permissionOrRoleHandlerMap)) {
            throw new IllegalArgumentException("工厂装配为空");
        }
        log.info("PermissionOrRoleFactory 初始化完成，包含 {} 个 handler", permissionOrRoleHandlerMap.size());
    }
}
