package Game1;

import java.io.*;
import java.net.Socket;

/**
 * 先用BIO写，之后能成功的话 用netty改进
 * Created by zhang on 2018/2/9.
 */
public class ModSocket {

    public static final String IP_ADDR = "localhost";//服务器地址
    public static final int PORT = 12345;//服务器端口号

    public static void main(String[] args) {
        System.out.println("客户端启动...");
        System.out.println("当接收到服务器端字符为 \"#\" 的时候, 客户端将终止\n");
        recieveDate("QUERY_MODE_INFO");

    }
    public static String recieveDate(String req){
        while (true) {
            Socket socket = null;
            try {
                //创建一个流套接字并将其连接到指定主机上的指定端口号
                socket = new Socket(IP_ADDR, PORT);

                //读取服务器端数据
                DataInputStream input = new DataInputStream(socket.getInputStream());
                //向服务器端发送数据
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                req = req.toUpperCase();
                System.out.print("请求："+req);
                out.writeUTF(req);

                String ret = input.readUTF();
                System.out.println("服务器端返回过来的是: " + ret);
                // 如接收到 "OK" 则断开连接
                if ("#".equals(ret)) {
                    System.out.println("客户端将关闭连接");
                    Thread.sleep(100);
                    break;
                }

                out.close();
                input.close();
            } catch (Exception e) {
                System.out.println("客户端异常:" + e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                        System.out.println("socket is closed");
                    } catch (IOException e) {
                        socket = null;//根据我对gc的理解 这句话应该是没有什么乱用的（也许吧）
                        System.out.println("客户端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
        return null;
    }
}
