package com.lj.blog.common.enums;

import com.lj.blog.common.constant.RoleConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName RoleEnum
 * @Description 系统角色
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/26 13:28
 * @Version JDK 17
 */
@AllArgsConstructor
@Getter
public enum RoleEnum {

    USER(RoleConstant.USER, "普通用户"),

    VIP_USER(RoleConstant.VIP_USR, "VIP用户"),

    SUPER_ADMIN(RoleConstant.SUPER_ADMIN, "超级管理员"),

    NORMAL_ADMIN(RoleConstant.NORMAL_ADMIN, "普通管理员");

    public static String getRoleByRoleEnglish(String roleEnglish){
        for(RoleEnum roleEnum : RoleEnum.values()){
            if(roleEnglish.equals(roleEnum.getRoleEnglish())){
                return roleEnum.getRole();
            }
        }
        return null;
    }

    private final String roleEnglish;
    private final String role;
}
