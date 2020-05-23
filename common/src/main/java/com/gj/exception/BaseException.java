package com.gj.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: BaseException
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/21 18:39
 * @Version: V1.0
 **/

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    public Integer code;
    public String message;

    public BaseException(){}

    public BaseException(Integer code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
