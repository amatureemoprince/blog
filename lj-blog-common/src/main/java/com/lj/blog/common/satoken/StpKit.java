package com.lj.blog.common.satoken;

import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;

/**
 * @ClassName StpKit
 * @Description 多账号管理
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/21 9:59
 * @Version JDK 17
 */
public class StpKit {

    public static final String ADMIN_ROLE = "admin";

    public static final String USER_ROLE = "user";

    /**
     * 默认原生会话对象
     */
    public static final StpLogic DEFAULT = StpUtil.stpLogic;

    /**
     * Admin 会话对象，管理 Admin 表所有账号的登录、权限认证
     */
    public static final StpLogic ADMIN = new StpLogic(StpKit.ADMIN_ROLE);

    /**
     * User 会话对象，管理 User 表所有账号的登录、权限认证
     */
    public static final StpLogic USER = new StpLogic(StpKit.USER_ROLE);

    /**
     * XX 会话对象，（项目中有多少套账号表，就声明几个 StpLogic 会话对象）
     */
    public static final StpLogic XXX = new StpLogic("xx");

}
