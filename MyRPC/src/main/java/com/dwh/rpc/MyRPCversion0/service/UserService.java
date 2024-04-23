package com.dwh.rpc.MyRPCversion0.service;

import com.dwh.rpc.MyRPCversion0.common.User;

/*
 *@title UserService
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/23 10:41
 */
public interface UserService {
    User getUserByUserId(Integer id);
}
