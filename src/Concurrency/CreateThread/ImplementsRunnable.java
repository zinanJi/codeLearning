package Concurrency.CreateThread;

/**
 * Created by zinan.ji on 2020-04-20.
 */
// 覆写Runnable接口实现多线程可以避免单继承局限
// 实现Runnable()可以更好的体现共享的概念
public class ImplementsRunnable implements Runnable{
    private static int count = 10;

    @Override
    public void run() {
        while (count >0){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"-当前剩余票数："+count--);
        }
    }

    public static void main(String[] args) {
        ImplementsRunnable task = new ImplementsRunnable();
        // 线程共用了一个task代码逻辑，也可以根据需要添加参数进行任务区分
        Thread mThread1 = new Thread(task,"线程1");
        Thread mThread2= new Thread(task,"线程2");
        Thread mThread3 = new Thread(task,"线程3");
        mThread1.start();
        mThread2.start();
        mThread3.start();
    }

}
