package com.gj.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "user-service")
public interface UserFeign {

    @GetMapping("/hello")
    String hello();
}
