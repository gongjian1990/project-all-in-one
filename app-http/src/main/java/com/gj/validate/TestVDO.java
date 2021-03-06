package com.gj.validate;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ClassName: TestVDO
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/22 15:25
 * @Version: V1.0
 *
 * 1 @NotEmpty :不能为null，且Size>0
 *
 * 2 @NotNull:不能为null，但可以为empty,没有Size的约束
 *
 * 3 @NotBlank:只用于String,不能为null且trim()之后size>0
 *
 **/
@Data
public class TestVDO {

    @NotNull(message = "userId 不能为空")
    private Long userId;

    @Range(min = 0,max = 10,message = "range 不在范围")
    private Long range;

    @NotBlank(message = "url地址不能为空")
    @Size(min = 5,max = 20,message = "字符长度必须在5-20之间")
    private String url;

}
