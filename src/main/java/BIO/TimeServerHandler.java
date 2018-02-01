package BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.net.Socket;

/**
 * Created by zhangguanlong on 2017/12/28.
 */
public class TimeServerHandler implements Runnable {

    private Socket Socket;


    public TimeServerHandler(Socket socket) {
        this.Socket = socket;
    }


    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.Socket.getInputStream()));
            out = new PrintWriter(this.Socket.getOutputStream(),true);
            String currentTime = null;
            String body = null;
            while (true) {
                body=in.readLine();
                if (body==null)
                    break;
                System.out.println("the time server recieved order:"+body);
                currentTime = "Query TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
                out.println(currentTime);

            }

        } catch (Exception e) {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out !=null) {
                out.close();
                out=null;
            }
            if (this.Socket==null) {
                try {
                    this.Socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.Socket=null;
            }
        }

    }

}