package com.dwh.rpc.MyRPCversion1.service;

import com.dwh.rpc.MyRPCversion1.common.Blog;

/*
 *@title BlogService
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/26 下午9:31
 */
public interface BlogService {
    Blog getBlogById(Integer id);
}
