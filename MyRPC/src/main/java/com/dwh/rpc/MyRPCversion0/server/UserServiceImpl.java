package com.dwh.rpc.MyRPCversion0.server;

import com.dwh.rpc.MyRPCversion0.common.User;
import com.dwh.rpc.MyRPCversion0.service.UserService;

import java.util.Random;
import java.util.UUID;

/*
 *@title UserServiceImpl
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/23 10:41
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUserId(Integer id) {
        System.out.println("客户端查询了"+id+"的用户");
        Random random = new Random();
        User user = User.builder().userName(UUID.randomUUID().toString())
                .id(id)
                .sex(random.nextBoolean()).build();
        return user;
    }

    @Override
    public Integer insertUserId(User user) {
        System.out.println("插入数据成功："+user);
        return 1;
    }
}
