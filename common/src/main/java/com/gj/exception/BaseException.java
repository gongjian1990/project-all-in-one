package com.gj.exception;

import lombok.Data;

/**
 * @ClassName: BaseException
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/21 18:39
 * @Version: V1.0
 **/

@Data
public class BaseException extends RuntimeException {

    public Integer code;
    public String message;

    public BaseException(Integer code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
