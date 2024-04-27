package com.dwh.rpc.MyRPCversion5.loadbalance;

import java.util.List;

/*
 *@title LoadBalance
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/27 下午3:47
 */
/**
 * 给服务器地址列表，根据不同的负载均衡策略选择一个
 */
public interface LoadBalance {
    String balance(List<String> addressList);
}
