package com.dwh.rpc.MyRPCversion1.server;

import com.dwh.rpc.MyRPCversion1.service.BlogService;
import com.dwh.rpc.MyRPCversion1.service.UserService;


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
        //Map<String, Object> serviceProvide = new HashMap<>();
        // 暴露两个服务接口， 即在RPCServer中加一个HashMap
        //serviceProvide.put("com.dwh.myRPCVersion1.service.UserService",userService);
        //serviceProvide.put("com.dwh.myRPCVersion1.service.BlogService",blogService);

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new SimpleRPCRPCServer(serviceProvider);
        RPCServer.start(8899);
    }
}
