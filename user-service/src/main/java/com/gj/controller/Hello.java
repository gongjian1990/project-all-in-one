package com.gj.controller;

import com.gj.exception.BizException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: Hello
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/20 18:43
 * @Version: V1.0
 **/

@RestController
public class Hello {

    @GetMapping("/hello")
    public String hello(){
        throw new BizException(200,"aa");
    }

}
