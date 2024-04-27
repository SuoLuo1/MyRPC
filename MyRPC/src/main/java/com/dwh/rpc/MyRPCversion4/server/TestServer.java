package com.dwh.rpc.MyRPCversion4.server;

import com.dwh.rpc.MyRPCversion4.service.BlogService;
import com.dwh.rpc.MyRPCversion4.service.BlogServiceImpl;
import com.dwh.rpc.MyRPCversion4.service.UserService;
import com.dwh.rpc.MyRPCversion4.service.UserServiceImpl;


/*
 *@title TestServer
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/26 下午9:40
 */
public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();

        ServiceProvider serviceProvider = new ServiceProvider("127.0.0.1", 8899);
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(8899);
    }
}
