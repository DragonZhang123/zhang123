package HttpSocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhang on 2018/1/30.
 */
public class MainServer {
    public static void main(String[] args) throws IOException {
        // 服务端创建一个监听
        ServerSocket serverSocket = new ServerSocket(9000);
        // 监听客户端连接，这里我们暂时没有多线程
        Socket socket = serverSocket.accept();

        // 要想获取客户端发送过来的内容，就要得到 InputStream类 的输入流对象
        InputStream inputStream = socket.getInputStream();

        //==========使用自定义的http处理的相关类===========//
        Request request = new Request(inputStream);
        System.out.println(request.readHtml());
        socket.close();
    }
}
