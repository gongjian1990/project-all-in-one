package com.gj;

import com.gj.test.el.ElRole2;
import com.gj.util.ApplicationContextProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: Test001
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/22 11:32
 * @Version: V1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class Test001 {

    @Autowired
    private ElRole2 elRole2;

    @Autowired
    ApplicationContextProvider applicationContextProvider;

    @Test
    public void test001(){
        ElRole2 role2 = applicationContextProvider.getApplicationContext().getBean(ElRole2.class);

        log.info("id: "+role2.getName());
    }



}
