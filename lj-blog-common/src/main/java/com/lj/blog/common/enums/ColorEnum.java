package com.lj.blog.common.enums;

import lombok.Getter;

/**
 * @ClassName ColorEnum
 * @Description 控制台输出颜色枚举
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/18 9:49
 * @Version JDK 17
 */
@Getter
public enum ColorEnum {
    // 普通颜色
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    // 高亮颜色
    BLACK_BRIGHT("\u001B[90m"),
    RED_BRIGHT("\u001B[91m"),
    GREEN_BRIGHT("\u001B[92m"),
    YELLOW_BRIGHT("\u001B[93m"),
    BLUE_BRIGHT("\u001B[94m"),
    PURPLE_BRIGHT("\u001B[95m"),
    CYAN_BRIGHT("\u001B[96m"),
    WHITE_BRIGHT("\u001B[97m"),
    // 重置
    RESET("\u001B[0m");
    private final String code;
    ColorEnum(String code){
        this.code = code;
    }
}
