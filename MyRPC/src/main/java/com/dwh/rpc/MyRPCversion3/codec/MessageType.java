package com.dwh.rpc.MyRPCversion3.codec;

import lombok.AllArgsConstructor;

/*
 *@title MessageType
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/27 下午2:27
 */
@AllArgsConstructor
public enum MessageType {
    REQUEST(0),RESPONSE(1);
    private int code;
    public int getCode() {
        return code;
    }
}
