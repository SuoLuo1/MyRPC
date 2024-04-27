package com.dwh.rpc.MyRPCversion3.server;

import com.dwh.rpc.MyRPCversion3.service.BlogService;
import com.dwh.rpc.MyRPCversion3.service.BlogServiceImpl;
import com.dwh.rpc.MyRPCversion3.service.UserService;
import com.dwh.rpc.MyRPCversion3.service.UserServiceImpl;


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

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(8899);
    }
}
