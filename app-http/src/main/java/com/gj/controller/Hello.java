package com.gj.controller;

import com.gj.feign.UserFeign;
import com.gj.validate.TestVDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName: Hello
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/21 19:40
 * @Version: V1.0
 **/
@RestController
@Validated
public class Hello {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/hello")
    public String hello(){
        // userFeign.hello();
        return "success";
    }

    @PostMapping("/testValidate")
    public String testValidate(@RequestBody @Valid TestVDO testVDO){

        System.out.println("testVDO: "+testVDO);
        return "success";
    }
}
