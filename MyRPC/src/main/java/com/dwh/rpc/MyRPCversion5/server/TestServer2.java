package com.dwh.rpc.MyRPCversion5.server;

import com.dwh.rpc.MyRPCversion5.service.BlogService;
import com.dwh.rpc.MyRPCversion5.service.BlogServiceImpl;
import com.dwh.rpc.MyRPCversion5.service.UserService;
import com.dwh.rpc.MyRPCversion5.service.UserServiceImpl;

/*
 *@title TestServer2
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/27 下午3:52
 */
public class TestServer2 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();

        ServiceProvider serviceProvider = new ServiceProvider("127.0.0.1", 8900);
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);
        RPCServer RPCServer = new NettyRPCServer(serviceProvider);

        RPCServer.start(8900);
    }
}
