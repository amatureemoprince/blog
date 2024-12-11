package com.lj.blog.common.result;

import com.lj.blog.common.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Result
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 10:09
 * @Version JDK 17
 */
@AllArgsConstructor
@Data
public class Result <T>{
    private int code;
    private String msg;
    private T data;
    public static <T> Result<T> success(){
        return new Result<>(ResultEnum.SUCCESS.getHttpCode(), ResultEnum.SUCCESS.getMsg(), null);
    }
    public static <T> Result<T> success(T date){
        return new Result<>(ResultEnum.SUCCESS.getHttpCode(), ResultEnum.SUCCESS.getMsg(), date);
    }
    public static <T> Result<T> success(String msg, T date){
        return new Result<>(ResultEnum.SUCCESS.getHttpCode(), msg, date);
    }

    public static <T> Result<T> error(){
        return new Result<>(ResultEnum.ERROR.getHttpCode(), ResultEnum.ERROR.getMsg(), null);
    }
    public static <T> Result<T> error(String msg){
        return new Result<>(ResultEnum.ERROR.getHttpCode(), msg, null);
    }

    public static <T> Result<T> error(T date){
        return new Result<>(ResultEnum.ERROR.getHttpCode(), ResultEnum.ERROR.getMsg(), date);
    }

    public static <T> Result<T> error(String msg, T data){
        return new Result<>(ResultEnum.ERROR.getHttpCode(), msg, data);
    }
}
