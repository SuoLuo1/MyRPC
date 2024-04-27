package com.dwh.rpc.MyRPCversion4.register;

/*
 *@title ServiceRegister
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/27 下午3:22
 */

import java.net.InetSocketAddress;

// 服务注册接口，两大基本功能，注册：保存服务与地址。 查询：根据服务名查找地址
public interface ServiceRegister {
    void register(String serviceName, InetSocketAddress serverAddress);

    InetSocketAddress serviceDiscovery(String serviceName);
}
