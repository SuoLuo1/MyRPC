package com.dwh.rpc.MyRPCversion2.client;

import com.dwh.rpc.MyRPCversion2.common.RPCRequest;
import com.dwh.rpc.MyRPCversion2.common.RPCResponse;
/*
 *@title RPCClient
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/23 10:46
 */
public interface RPCClient {
    RPCResponse sendRequest(RPCRequest response);
}
