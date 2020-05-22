package com.gj.test.el;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ElRole2
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/22 11:31
 * @Version: V1.0
 **/
@Component("elRole")
@Data
public class ElRole2 {

    @Value("#{role2}")
    private Role2 role2;

    @Value("#{role2.id}")
    private Long id;

    @Value("#{role2.roleName}")
    private String name;
}
