package AIO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * Created by zhang on 2018/1/6.
 */
public class ReadCompletionHandler implements CompletionHandler<Integer,ByteBuffer>{
    private AsynchronousSocketChannel channel;
    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
        if (this.channel == null) {
            this.channel =channel;
        }
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
    attachment.flip();
    byte[] body = new byte[attachment.remaining()];
    attachment.get(body);
        try {
            String req = new String(body,"UTF-8");
            System.out.println("Time server receive order : "+req);
            String currentName = "QUERY TIME ORDER".equalsIgnoreCase(req)?new Date().toString():"BAD ORDER";
            doWrite(currentName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String currentName) {
        if (currentName != null&&currentName.length()>0) {
            byte[] bytes =currentName.getBytes();
            ByteBuffer writeBuffer =ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer byteBuffer) {
                    if (byteBuffer.hasRemaining()){
                        channel.write(byteBuffer,byteBuffer,this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
