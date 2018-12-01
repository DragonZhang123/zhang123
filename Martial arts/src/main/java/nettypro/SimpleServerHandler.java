/*
package nettypro;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

*/
/**
 * Created by zhang on 2018/2/2.
 *//*

public class SimpleServerHandler extends ChannelInboundHandlerAdapter {
    */
/**
     * 读取客户端通道的数据
     * @param ctx
     * @param msg
     * @throws Exception
     *//*

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof ByteBuf){
            //打印 传输 all test
            System.out.println(((ByteBuf) msg).toString(Charset.defaultCharset()));
        }
        ctx.writeAndFlush("is ok");
    }
}
*/
