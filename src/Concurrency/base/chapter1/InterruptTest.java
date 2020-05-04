package Concurrency.base.chapter1;

/**
 * Created by zinan.ji on 2020-04-22.
 */
// interrupted()和isInterrupt()的区别
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个死循环线程
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                /*for (;;){

                }*/
                // 中断标志为true时会退出循环，并且清楚中断标志
                while(!Thread.currentThread().interrupted()) {}
                System.out.println("ThreadOne isInterrupted:" + Thread.currentThread().isInterrupted());
            }
        });
        // 启动线程
        threadOne.start();

        // 设置中断标志
        threadOne.interrupt();

        /*// 获取中断标志
        System.out.println("和isInterrupt:" + threadOne.isInterrupted());

        // 获取中断标志并重置(当前线程是main)
        System.out.println("和isInterrupt:" + threadOne.interrupted());

        // 获取中断标志并重置
        System.out.println("和isInterrupt:" + Thread.interrupted());

        // 获取中断标志
        System.out.println("和isInterrupt:" + threadOne.isInterrupted());*/

        threadOne.join();
        System.out.println("main thread is over");
    }
}
