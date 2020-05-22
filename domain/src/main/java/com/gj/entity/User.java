package com.gj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: User
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/20 19:02
 * @Version: V1.0
 **/
@TableName("user")
@Data
public class User {

    private Long uid;

    private String username;

    private String nickname;

    private String phone;

    private Integer age;

    private Integer deleted;

    private Date createTime;

    private Date lastUpdateTime;
}
