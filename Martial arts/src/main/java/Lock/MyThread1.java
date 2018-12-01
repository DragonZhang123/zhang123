package Lock;

public class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);//传递线程的名字
    }
    public static void main(String[] args) {
// TODO Auto-generated method stub
        for (int i = 0; i < 5; i++) { //创建5个线程
            new MyThread1("thread" + i).start();
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {//输出线程名字和i
            System.out.println(this.getName() + ":" + i);
        }
    }
}