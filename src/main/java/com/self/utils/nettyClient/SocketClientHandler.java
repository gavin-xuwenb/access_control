package com.self.utils.nettyClient;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SocketClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();

        ByteBuf responseBuf = (ByteBuf)msg;
        
        
        byte[] sbody = new byte[8];
        responseBuf.readBytes(sbody);
        String str = StringUtil.toHexString(sbody);

        System.out.println("服务器返回---->"+str);
        

        int length = responseBuf.readInt();
        int seq = responseBuf.readInt();

        responseBuf.resetReaderIndex();

        //获取消息对应的callback
        SocketClient.CallbackService callbackService = ChannelUtils.<SocketClient.CallbackService>removeCallback(channel, seq);
        callbackService.receiveMessage(responseBuf);
    }
}