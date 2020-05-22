package com.gj.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ApplicationContextProvider
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/22 13:49
 * @Version: V1.0
 **/
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    // 上下文实例
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
