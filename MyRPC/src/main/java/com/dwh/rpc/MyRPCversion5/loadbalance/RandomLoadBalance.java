package com.dwh.rpc.MyRPCversion5.loadbalance;

/*
 *@title RandomLoadBalance
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/27 下午3:47
 */

import java.util.List;
import java.util.Random;

/**
 * 随机负载均衡
 */
public class RandomLoadBalance implements LoadBalance{
    @Override
    public String balance(List<String> addressList) {

        Random random = new Random();
        int choose = random.nextInt(addressList.size());
        System.out.println("负载均衡选择了" + choose + "服务器");
        return addressList.get(choose);
    }
}
