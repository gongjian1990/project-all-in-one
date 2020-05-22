package com.gj.test.el;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Role2
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/22 11:28
 * @Version: V1.0
 **/
@Component("role2")
@Data
public class Role2 {

    @Value("#{2}")
    private Long id;

    @Value("#{'项目经理'}")
    private String roleName;
}
