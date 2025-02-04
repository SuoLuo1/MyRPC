package com.dwh.rpc.MyRPCversion1.client;

import com.dwh.rpc.MyRPCversion1.common.Blog;
import com.dwh.rpc.MyRPCversion1.common.User;
import com.dwh.rpc.MyRPCversion1.service.BlogService;
import com.dwh.rpc.MyRPCversion1.service.UserService;

/*
 *@title RPCClient
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/23 10:46
 */
public class RPCClient {
    public static void main(String[] args) {
        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8899);
        UserService proxy = clientProxy.getProxy(UserService.class);

        // 服务的方法1
        User userByUserId = proxy.getUserByUserId(10);
        System.out.println("从服务端得到的user为：" + userByUserId);
        // 服务的方法2
        User user = User.builder().userName("张三").id(100).sex(true).build();
        Integer integer = proxy.insertUserId(user);
        System.out.println("向服务端插入数据："+integer);

        BlogService blogService = clientProxy.getProxy(BlogService.class);
        Blog blogById = blogService.getBlogById(10000);
        System.out.println("从服务端得到的blog为：" + blogById);
    }
}
