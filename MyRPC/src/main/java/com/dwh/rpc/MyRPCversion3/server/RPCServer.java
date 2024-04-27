package com.dwh.rpc.MyRPCversion3.server;

/*
 *@title RPCServer
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/23 10:57
 */
public interface RPCServer {
    void start(int port);
    void stop();
}
