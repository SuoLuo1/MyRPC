package com.dwh.rpc.MyRPCversion4.client;

import com.dwh.rpc.MyRPCversion4.common.Blog;
import com.dwh.rpc.MyRPCversion4.common.User;
import com.dwh.rpc.MyRPCversion4.service.BlogService;
import com.dwh.rpc.MyRPCversion4.service.UserService;

/*
 *@title TestClient
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/27 上午10:43
 */
public class TestClient {
    public static void main(String[] args) {
        // 构建一个使用java Socket/ netty/....传输的客户端
        RPCClient rpcClient = new NettyRPCClient();
        // 把这个客户端传入代理客户端
        ClientProxy rpcClientProxy = new ClientProxy(rpcClient);
        // 代理客户端根据不同的服务，获得一个代理类， 并且这个代理类的方法以或者增强（封装数据，发送请求）
        UserService userService = rpcClientProxy.getProxy(UserService.class);
        // 调用方法
        User userByUserId = userService.getUserByUserId(10);
        System.out.println("从服务端得到的user为：" + userByUserId);

        User user = User.builder().userName("张三").id(100).sex(true).build();
        Integer integer = userService.insertUserId(user);
        System.out.println("向服务端插入数据："+integer);

        BlogService blogService = rpcClientProxy.getProxy(BlogService.class);

        Blog blogById = blogService.getBlogById(10000);
        System.out.println("从服务端得到的blog为：" + blogById);
    }
}
