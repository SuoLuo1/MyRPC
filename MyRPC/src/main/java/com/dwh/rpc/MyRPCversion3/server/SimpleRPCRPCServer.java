package com.dwh.rpc.MyRPCversion3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 *@title SimpleRPCRPCServer
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/26 下午9:41
 */
public class SimpleRPCRPCServer implements RPCServer {
    // 存着服务接口名-> service对象的map
    private ServiceProvider serviceProvide;

    public SimpleRPCRPCServer(ServiceProvider serviceProvide){
        this.serviceProvide = serviceProvide;
    }

    @Override
    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动了");
            // BIO的方式监听Socket
            while (true){
                Socket socket = serverSocket.accept();
                // 开启一个新线程去处理
                new Thread(new WorkThread(socket,serviceProvide)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }

    @Override
    public void stop() {

    }
}
