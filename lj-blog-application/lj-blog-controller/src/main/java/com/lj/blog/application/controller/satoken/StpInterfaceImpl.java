package com.lj.blog.application.controller.satoken;

import cn.dev33.satoken.stp.StpInterface;
import com.lj.blog.common.utils.LogUtil;
import com.lj.blog.domain.serivce.imp.BlogUserDomainServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private BlogUserDomainServiceImp blogUserDomainService;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        log.info("获取权限列表，loginId: {}, loginType: {}", loginId, loginType);
        if("admin".equals(loginType)){
            List<String> list = new ArrayList<String>();
            list.add("101");
            list.add("user.add");
            list.add("user.update");
            list.add("user.get");
            // list.add("user.delete");
            list.add("art.*");
            log.info(LogUtil.blue("验证的type为" + loginType));
            return list;
        }
        return null;
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
