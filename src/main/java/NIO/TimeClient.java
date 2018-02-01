package NIO;

import java.io.*;
import java.net.Socket;

/**
 * Created by zhangguanlong on 2017/12/28.
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8380;
        if (args == null&&args.length>0) {
            port = Integer.valueOf(args[0]);
        }
        new Thread(new TimeClientHandle("127.0.0.1",port),"TimeClient-001").start();

    }
}
