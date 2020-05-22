package com.gj.res;

import com.gj.exception.BaseException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: 通用返回实体类
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/21 18:34
 * @Version: V1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T>{

    private Integer code;

    private String message;

    private T data;

    public static Response success(){
        return new Response(ResStatus.SUCCESS.getCode(),ResStatus.SUCCESS.getMessage(),null);
    }

    public static Response success(String message){
        return new Response(ResStatus.SUCCESS.getCode(),message,null);
    }

    public static<T> Response success(String message,T data){
        return new Response<T>(ResStatus.SUCCESS.getCode(),message,data);
    }

    public static Response error(){
        return new Response(ResStatus.SERVER_ERROR.getCode(),ResStatus.SERVER_ERROR.getMessage(),null);
    }

    public static<T> Response error(String message){
        return new Response(ResStatus.SERVER_ERROR.getCode(),message,null);
    }

    public static<T> Response error(String message,T data){
        return new Response(ResStatus.SERVER_ERROR.getCode(),message,data);
    }

    public static<T> Response success(ResStatus resStatus,T data){
        return new Response(resStatus.getCode(),resStatus.getMessage(),data);
    }

    public static<T> Response error(ResStatus resStatus,T data){
        return new Response(resStatus.getCode(),resStatus.getMessage(),data);
    }


}
