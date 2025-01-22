package com.lj.blog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * @ClassName GlobalEnum
 * @Description 同一响应返回信息
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 8:30
 * @Version JDK 17
 */
@AllArgsConstructor
@Getter
public enum GlobalEnum {
    WEBSITE_NAME(10000, "朝花夕拾_"),
    IS_DELETED(1, "删除"),
    IS_NOT_DELETED(0, "未删除");
    public static GlobalEnum getEnumByCode(int code){
        for (GlobalEnum item : GlobalEnum.values()) {
            if (item.code == code) {
                return item;
            }
        }
        return null;
    }
    public final int code;
    public final String msg;
}
