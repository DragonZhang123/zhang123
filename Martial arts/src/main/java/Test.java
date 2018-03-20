import java.lang.Thread;
import java.text.SimpleDateFormat;
public class Test {
    public static void main(String[] args) {
        long time_start;
        int fulltime = 100;
        int runtime = 50;
        while(true){
            time_start = System.currentTimeMillis();
            while((System.currentTimeMillis()-time_start)<runtime){}
            try {
                Thread.sleep(fulltime-runtime);
            }catch (InterruptedException e) {
                return;
            }
        }
    }
}