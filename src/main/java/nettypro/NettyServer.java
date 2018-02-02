package nettypro;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by zhang on 2018/2/2.
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap server = new ServerBootstrap();
//        1.绑定  两个线程组 处理accept 和读写
//        2.绑定 服务端通道 NIO serverSocketChannel
//        3.给读写事件 的线程通道 绑定handler 真正处理读写
//        4.监听端口
        EventLoopGroup parentLoop = new NioEventLoopGroup();
        EventLoopGroup childLoop = new NioEventLoopGroup();
        server.group(parentLoop,childLoop);

        server.channel(NioServerSocketChannel.class);

        server.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new SimpleServerHandler());
            }
        });
        ChannelFuture channelFuture = server.bind(9000).sync();
        channelFuture.channel().closeFuture().sync();

    }
}
