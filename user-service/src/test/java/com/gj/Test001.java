package com.gj;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gj.entity.User;
import com.gj.dao.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName: Test001
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/21 18:11
 * @Version: V1.0
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class Test001 {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testList(){
        List<User> list = userMapper.selectList(new LambdaQueryWrapper<>());

        log.info("list: {}",list);
    }
}
