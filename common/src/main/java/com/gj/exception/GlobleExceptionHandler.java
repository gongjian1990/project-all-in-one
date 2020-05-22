package com.gj.exception;

import com.gj.res.ResStatus;
import com.gj.res.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

/**
 * @ClassName: GlobleExceptionHandler
 * @Description: 全局异常处理器
 * @Author: 赵云
 * @Date: 2020/5/21 18:37
 * @Version: V1.0
 **/

@RestControllerAdvice
@Slf4j
public class GlobleExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Response exceptionHandler(Exception e){
        log.info("全局异常处理。。。,{}",e);

        StringJoiner message = new StringJoiner(",");

        if (e instanceof ConstraintViolationException){
            ConstraintViolationException violationException = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations = violationException.getConstraintViolations();
            if (!CollectionUtils.isEmpty(violations)){
                for (ConstraintViolation<?> violation : violations) {
                    message.add(violation.getMessage());
                }
            }
        }
        // 参数校验不通过异常
        if (e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            List<ObjectError> errors = exception.getBindingResult().getAllErrors();
            if (!CollectionUtils.isEmpty(errors)){
                for (ObjectError error : errors) {
                    message.add(error.getDefaultMessage());
                }
            }
        }

       return Response.error(message.toString(),null);
    }

    @ExceptionHandler(BizException.class)
    public Response BizExceptionHandler(BizException e){
        log.info("业务异常。。。，{}",e);
        return Response.error(ResStatus.BIZ_EXCEPTION,null);
    }

}
