package AIO;



import java.io.IOException;

/**
 * Created by zhang on 2018/1/6.
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8380;
        if (args != null&& args.length>0) {
            try {
                port=Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer,"AIO-AsyncTimwServerHandler-001").start();

    }
}
