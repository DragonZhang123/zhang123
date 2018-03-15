package ping;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 一直ping某个ip
 * 事实证明 貌似没啥乱用
 * Created by zhang on 2018/2/6.
 */
public class OnePing extends Thread{
    public static final int MAXTHREAD =10000;
    @Override
    public void run() {
        Runtime runtime = Runtime.getRuntime();

        Process process = null;

        String command = "ping 192.168.1.125";

        String str = "";

        try {

            process = runtime.exec(command);

            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());

            char[] by = new char[1024];

          /*  while(inputStreamReader.read(by)!=-1){

                System.out.println(new String(by));
            }*/

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<MAXTHREAD;i++){
            new OnePing().start();
            System.out.println(i);
        }

    }
}
