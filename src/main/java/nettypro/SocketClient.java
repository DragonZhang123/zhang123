package nettypro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by zhang on 2018/2/2.
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9000);
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        output.writeInt(4);
        output.writeBytes("ssssssss\r\neeeeeee");
        output.flush();

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        int length = inputStream.readInt();
        byte[] b = new byte[length];
        inputStream.readFully(b,0,length);
        System.out.println("print:");
        System.out.println(new String(b));
        socket.close();

    }
}
