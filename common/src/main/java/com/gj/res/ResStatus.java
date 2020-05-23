package com.gj.res;

import lombok.Getter;

/**
 * @ClassName: ResStatus
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/21 18:56
 * @Version: V1.0
 **/

@Getter
public enum ResStatus implements IResponseEnum {

    BIZ_EXCEPTION(101,"操作异常"),

    SUCCESS(200,"操作成功。"),

    SERVER_ERROR(500,"服务器异常"),

    PARAMETER_ERROR(40001,"请求参数错误");



    ;


    private Integer code;

    private String message;

    ResStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
