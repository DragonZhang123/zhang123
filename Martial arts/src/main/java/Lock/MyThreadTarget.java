package Lock;

public class MyThreadTarget implements Runnable{
    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            Runnable r =new MyThreadTarget();
            //把目标对象传递个Thread，即虚拟的cpu
            new Thread(r, "thread" + i).start();
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
