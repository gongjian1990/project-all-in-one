package com.gj.exception;

import lombok.Data;

/**
 * @ClassName: UnAuthException
 * @Description: 权限异常
 * @Author: 赵云
 * @Date: 2020/5/23 10:39
 * @Version: V1.0
 **/
@Data
public class UnAuthException extends BaseException {

    public UnAuthException() {
        super();
    }

    public UnAuthException(Integer code, String message) {
        super(code, message);
    }
}
