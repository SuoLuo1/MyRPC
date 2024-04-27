package com.dwh.rpc.MyRPCversion5.server;

import com.dwh.rpc.MyRPCversion5.service.BlogService;
import com.dwh.rpc.MyRPCversion5.service.BlogServiceImpl;
import com.dwh.rpc.MyRPCversion5.service.UserService;
import com.dwh.rpc.MyRPCversion5.service.UserServiceImpl;


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
        // 这里重用了服务暴露类，顺便在注册中心注册，实际上应分开，每个类做各自独立的事
        ServiceProvider serviceProvider = new ServiceProvider("127.0.0.1", 8899);
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(8899);
    }
}
