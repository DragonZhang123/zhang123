package HttpSocket;

/**
 * Created by zhang on 2018/1/30.
 */

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 接受HTTP请求
 */
public class Request {
    // 用来保存输入流对象
    private InputStream inputStream;
    // 从输入流中每次读取的字节长度
    private int bufferLength = 1024;

    /**
     * 构造函数
     * @param inputStream
     */
    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 读取内容 返回字符串
     * @return
     * @throws IOException
     */
    public String readHtml() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(this.inputStream);
        byte[] buffer = new byte[this.bufferLength];
        StringBuilder stringBuilder = new StringBuilder();
        int len = 0;
        while (true){
            len = bufferedInputStream.read(buffer);
            stringBuilder.append(new String(buffer,0,len));
            if (len <= 0 || len<this.bufferLength){
                break;
            }
        }
        return stringBuilder.toString();
    }
}
