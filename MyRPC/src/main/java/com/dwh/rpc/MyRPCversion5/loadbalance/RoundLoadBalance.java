package com.dwh.rpc.MyRPCversion5.loadbalance;

/*
 *@title RoundLoadBalance
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/27 下午3:48
 */

import java.util.List;

/**
 * 轮询负载均衡
 */
public class RoundLoadBalance implements LoadBalance{
    private int choose = -1;
    @Override
    public String balance(List<String> addressList) {
        choose++;
        choose = choose%addressList.size();
        return addressList.get(choose);
    }
}
