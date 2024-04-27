package com.dwh.rpc.MyRPCversion4.service;

import com.dwh.rpc.MyRPCversion4.common.User;

/*
 *@title UserService
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/23 10:41
 */
public interface UserService {
    // 客户端通过这个接口调用服务端的实现类
    User getUserByUserId(Integer id);
    // 给这个服务增加一个功能
    Integer insertUserId(User user);
}
