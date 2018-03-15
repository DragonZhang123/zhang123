package HttpSocket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zhang on 2018/1/30.
 */
public class Response {

    private OutputStream outputStream;

    public Response(OutputStream outputStream){
        this.outputStream = outputStream;
    }
    public void writeHtml(String html) throws IOException {
        html = "http/1.1 200 ok\n"
                +"\n\n"
                +html;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.outputStream);
        bufferedOutputStream.write(html.getBytes());
        bufferedOutputStream.close();
    }

}
