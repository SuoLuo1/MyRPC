package com.dwh.rpc.MyRPCversion1.server;

import com.dwh.rpc.MyRPCversion1.common.RPCRequest;
import com.dwh.rpc.MyRPCversion1.common.RPCResponse;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/*
 *@title WorkThread
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/26 下午9:45
 */
@AllArgsConstructor
public class WorkThread implements Runnable {
    private Socket socket;
    private ServiceProvider serviceProvide;
    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            // 读取客户端传过来的request
            RPCRequest request = (RPCRequest) ois.readObject();
            // 反射调用服务方法获得返回值
            RPCResponse response = getResponse(request);
            //写入到客户端
            oos.writeObject(response);
            oos.flush();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("从IO中读取数据错误");
        }
    }

    private RPCResponse getResponse(RPCRequest request){
        // 得到服务名
        String interfaceName = request.getInterfaceName();
        // 得到服务端相应服务实现类
        Object service = serviceProvide.getService(interfaceName);
        // 反射调用方法
        Method method = null;
        try {
            method = service.getClass().getMethod(request.getMethodName(), request.getParamsTypes());
            Object invoke = method.invoke(service, request.getParams());
            return RPCResponse.success(invoke);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("方法执行错误");
            return RPCResponse.fail();
        }
    }
}
