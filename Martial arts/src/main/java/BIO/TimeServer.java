package BIO;

/**
 * Created by zhangguanlong on 2017/12/28.
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8380;
        if (args != null&& args.length>0) {
            port=Integer.valueOf(args[0]);
        }
        ServerSocket server = null;
        try {
            server= new ServerSocket(port);
            System.out.println("The time server is start on port:"+port);
            Socket socket =null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50,10000);//io任务线程池
            while (true) {
                socket=server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            if (server != null) {
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }

    }

}