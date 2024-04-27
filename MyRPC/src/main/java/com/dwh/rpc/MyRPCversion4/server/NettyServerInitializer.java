package com.dwh.rpc.MyRPCversion4.server;

import com.dwh.rpc.MyRPCversion4.codec.JsonSerializer;
import com.dwh.rpc.MyRPCversion4.codec.MyDecode;
import com.dwh.rpc.MyRPCversion4.codec.MyEncode;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lombok.AllArgsConstructor;

/*
 *@title NettyServerInitializer
 *@description
 *@author DWH
 *@version 1.0
 *@create 2024/4/27 上午10:54
 */
@AllArgsConstructor
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    private ServiceProvider serviceProvider;
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 使用自定义的编解码器
        pipeline.addLast(new MyDecode());
        // 编码需要传入序列化器，这里是json，还支持ObjectSerializer，也可以自己实现其他的
        pipeline.addLast(new MyEncode(new JsonSerializer()));
        pipeline.addLast(new NettyRPCServerHandler(serviceProvider));
    }
}
