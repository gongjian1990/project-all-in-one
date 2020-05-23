package com.gj.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: WebLogAspect
 * @Description: 记录所有controller方法执行日志
 * @Author: 赵云
 * @Date: 2020/5/23 14:21
 * @Version: V1.0
 **/

@Component
@Aspect
@Slf4j
public class WebLogAspect {

    @Pointcut("execution( * com.gj.controller.*.*(..))")
    public void logPointCut(){}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint){

        Object result = null;
        long start = System.currentTimeMillis();
        final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        final HttpServletRequest request = requestAttributes.getRequest();
        final String uri = request.getRequestURI();

        final Signature signature = joinPoint.getSignature();
        final String methodName = signature.getName();

        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            log.info("\n\t" +
                    "请求路径： -----------{} \n\t" +
                    "请求参数：------------{} \n\t" +
                    "耗时：---------------{} \n\t"
                    ,(uri+"."+methodName), joinPoint.getArgs(),(System.currentTimeMillis()-start));
        }
        
        return result;
    }
}
