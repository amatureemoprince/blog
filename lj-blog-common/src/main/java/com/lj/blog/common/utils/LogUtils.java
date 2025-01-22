package com.lj.blog.common.utils;

import com.lj.blog.common.enums.ColorEnum;

/**
 * @ClassName LogUtils
 * @Description 输出工具类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/18 9:40
 * @Version JDK 17
 */
public class LogUtils {

    public static String color(String message, ColorEnum color){
        return color.getCode() + message + ColorEnum.RESET.getCode();
    }

    public static String red(String message){
        return ColorEnum.RED_BRIGHT.getCode() + message + ColorEnum.RESET.getCode();
    }

    public static String green(String message){
        return ColorEnum.GREEN_BRIGHT.getCode() + message + ColorEnum.RESET.getCode();
    }

    public static String blue(String message){
        return ColorEnum.BLUE_BRIGHT.getCode() + message + ColorEnum.RESET.getCode();
    }

    public static String yellow(String message){
        return ColorEnum.YELLOW_BRIGHT.getCode() + message + ColorEnum.RESET.getCode();
    }

}
