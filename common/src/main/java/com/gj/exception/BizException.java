package com.gj.exception;

import com.gj.res.ResStatus;
import lombok.Data;

/**
 * @ClassName: BizException
 * @Description: 业务异常类
 * @Author: 赵云
 * @Date: 2020/5/21 18:38
 * @Version: V1.0
 **/
@Data
public class BizException extends BaseException {

    private String detail;

    public BizException(Integer code, String message) {
        super(code, message);
    }

    public BizException(String message) {
        super(ResStatus.BIZ_EXCEPTION.getCode(), message);
    }
}
