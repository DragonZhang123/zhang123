package Lock;

public class SleepTest {
    public static void main(String[] arg) {
        String[] args = { "one", "two", "three", "for" };
        long start=System.nanoTime();
        for (int i = 0; i < args.length; i++) {
            try {
                System.out.println(args[i]);
                // 休眠主线程
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end=System.nanoTime();
        System.out.println("总的时间："+(end-start)/1000000);
    }
}