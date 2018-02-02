package Lock;

/**
 * 局部变量并不会数据共享
 * Created by zhang on 2018/2/2.
 */
public class T1 {
    public static void main(String[] args) {
        PrivateNum p=new PrivateNum();
        MyThread threadA=new MyThread('A',p);
        MyThread2 threadB=new MyThread2('B',p);
        threadA.start();
        threadB.start();
    }}
class MyThread extends Thread
{
    char i;
    PrivateNum p;
    public MyThread(char i,PrivateNum p)
    {
        this.i=i;
        this.p=p;
    }

    public void run()
    {
        p.test2(i);
    }
}
class MyThread2 extends Thread
{
    char i;
    PrivateNum p;
    public MyThread2(char i,PrivateNum p)
    {
        this.i=i;
        this.p=p;
    }
    public void run()
    {
        p.test2(i);
    }
}
class PrivateNum
{

    public void test( char i)
    {
        try {
            int num=0;
            if(i=='A')
            {
                num=100;

                System.out.println("线程A已经设置完毕");
                Thread.sleep(1000);
            }
            else
            {
                num=200;
                System.out.println("线程B已经设置完毕");
            }
            System.out.println("线程"+i+"的值："+num);

        }
        catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }}
    public synchronized  void test2( char i)
    {
        int num=0;
        try {

            if(i=='A')
            {
                num=100;

                System.out.println("线程A已经设置完毕");
                Thread.sleep(1000);
            }
            else
            {
                num=200;
                System.out.println("线程B已经设置完毕");
            }
            System.out.println("线程"+i+"的值："+num);

        }
        catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }}
    public  void test3(char i)
    {
        System.out.println("线程"+i+"执行，线程A同步执行");
    }
}