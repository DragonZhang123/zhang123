package HttpSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhang on 2018/1/30.
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        // 服务端创建一个监听
        ServerSocket serverSocket = new ServerSocket(9000);
        // 监听客户端连接，暂时不用多线程
        Socket socket = serverSocket.accept();

        // 获取客户端发送过来的内容，得到 InputStream类 的输入流对象
        InputStream inputStream = socket.getInputStream();

        //==========使用自定义的http处理的相关类===========//
        Request request = new Request(inputStream);
        System.out.println(request.readHtml());

        // 给客户端发送数据，就要得到
        OutputStream outputStream = socket.getOutputStream();
        Response response = new Response(outputStream);
        response.writeHtml("this is my server");

        // 关闭
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
