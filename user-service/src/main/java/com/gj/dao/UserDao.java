package com.gj.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gj.dao.mapper.UserMapper;
import com.gj.entity.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName: UserDao
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/21 19:58
 * @Version: V1.0
 **/
@Component
public class UserDao extends ServiceImpl<UserMapper, User> {
}
