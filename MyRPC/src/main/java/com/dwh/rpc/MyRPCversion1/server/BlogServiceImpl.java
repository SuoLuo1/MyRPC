package com.dwh.rpc.MyRPCversion1.server;

import com.dwh.rpc.MyRPCversion1.common.Blog;
import com.dwh.rpc.MyRPCversion1.service.BlogService;

/*
 *@title BlogServiceImpl
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/26 下午9:39
 */
public class BlogServiceImpl implements BlogService {
    @Override
    public Blog getBlogById(Integer id) {
        Blog blog = Blog.builder().id(id).title("我的博客").useId(22).build();
        System.out.println("客户端查询了"+id+"博客");
        return blog;
    }
}
