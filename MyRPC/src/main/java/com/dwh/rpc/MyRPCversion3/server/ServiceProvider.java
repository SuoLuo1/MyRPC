package com.dwh.rpc.MyRPCversion3.server;


import java.util.HashMap;
import java.util.Map;

/*
 *@title ServiceProvider
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/26 下午9:46
 */
public class ServiceProvider {
    /**
     * 一个实现类可能实现多个接口
     */
    private Map<String, Object> interfaceProvider;

    public ServiceProvider(){
        this.interfaceProvider = new HashMap<>();
    }

    public void provideServiceInterface(Object service){
        Class<?>[] interfaces = service.getClass().getInterfaces();

        for(Class clazz : interfaces){
            interfaceProvider.put(clazz.getName(),service);
        }

    }

    public Object getService(String interfaceName){
        return interfaceProvider.get(interfaceName);
    }
}
