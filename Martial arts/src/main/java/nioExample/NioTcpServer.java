package nioExample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
/**
 * Created by zhang on 2018/1/6.
 */
public class NioTcpServer extends Thread {

    private static final Logger log = Logger.getLogger(NioTcpServer.class.getName());
    private InetSocketAddress inetSocketAddress;
    private Handler handler = new ServerHandler();

    public NioTcpServer(String hostname, int port) {
        inetSocketAddress = new InetSocketAddress(hostname, port);
    }

    @Override
    public void run() {
        try {
            Selector selector = Selector.open(); // 打开选择器
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(); // 打开通道
            serverSocketChannel.configureBlocking(false); // 非阻塞
            serverSocketChannel.socket().bind(inetSocketAddress);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); // 向通道注册选择器和对应事件标识
            log.info("Server: socket server started.");
            while(true) { // 轮询
                int nKeys = selector.select();
                if(nKeys>0) {
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    Iterator<SelectionKey> it = selectedKeys.iterator();
                    while(it.hasNext()) {
                        SelectionKey key = it.next();
                        if(key.isAcceptable()) {
                            log.info("Server: SelectionKey is acceptable.");
                            handler.handleAccept(key);
                        } else if(key.isReadable()) {
                            log.info("Server: SelectionKey is readable.");
                            handler.handleRead(key);
                        } else if(key.isWritable()) {
                            log.info("Server: SelectionKey is writable.");
                            handler.handleWrite(key);
                        }
                        it.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 简单处理器接口
     *
     * @author shirdrn
     */
    interface Handler {
        /**
         * 处理{@link SelectionKey#OP_ACCEPT}事件
         * @param key
         * @throws IOException
         */
        void handleAccept(SelectionKey key) throws IOException;
        /**
         * 处理{@link SelectionKey#OP_READ}事件
         * @param key
         * @throws IOException
         */
        void handleRead(SelectionKey key) throws IOException;
        /**
         * 处理{@link SelectionKey#OP_WRITE}事件
         * @param key
         * @throws IOException
         */
        void handleWrite(SelectionKey key) throws IOException;
    }

    /**
     * 服务端事件处理实现类
     *
     * @author shirdrn
     */
    class ServerHandler implements Handler {

        @Override
        public void handleAccept(SelectionKey key) throws IOException {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            log.info("Server: accept client socket " + socketChannel);
            socketChannel.configureBlocking(false);
            socketChannel.register(key.selector(), SelectionKey.OP_READ);
        }

        @Override
        public void handleRead(SelectionKey key) throws IOException {
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            SocketChannel socketChannel = (SocketChannel)key.channel();
            while(true) {
                int readBytes = socketChannel.read(byteBuffer);
                if(readBytes>0) {
                    log.info("Server: readBytes = " + readBytes);
                    log.info("Server: data = " + new String(byteBuffer.array(), 0, readBytes));
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                    break;
                }
            }
            socketChannel.close();
        }

        @Override
        public void handleWrite(SelectionKey key) throws IOException {
            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
            byteBuffer.flip();
            SocketChannel socketChannel = (SocketChannel)key.channel();
            socketChannel.write(byteBuffer);
            if(byteBuffer.hasRemaining()) {
                key.interestOps(SelectionKey.OP_READ);
            }
            byteBuffer.compact();
        }
    }

    public static void main(String[] args) {
        NioTcpServer server = new NioTcpServer("localhost", 1000);
        server.start();
    }
}
