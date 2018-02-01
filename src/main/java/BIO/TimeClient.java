package BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
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
        Socket socket = null;
        BufferedReader in =null;
        PrintWriter out = null;
        try {
            socket =new Socket("127.0.0.1",port);
            in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            out.println("Query TIME ORDER");
            System.out.println("send order 2 server succeed.");
            String res = in.readLine();
            System.out.println("Now is "+res);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
            if (socket==null) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                socket=null;
            }
        }
    }
}
