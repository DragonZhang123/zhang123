package NIO;

/**
 * Created by zhangguanlong on 2017/12/28.
 */
import BIO.TimeServerHandler;
import BIO.TimeServerHandlerExecutePool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8380;
        if (args != null&& args.length>0) {
            port=Integer.valueOf(args[0]);
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }

}