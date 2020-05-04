package Concurrency.CreateThread;

/**
 * Created by zinan.ji on 2020-04-20.
 */
// 继承Thread并重写run方法
public class extendsThread extends Thread {
    public extendsThread() {
    }
    @Override
    public void run(){
        for (int i = 0;i<10;i++){
            // 继承的好处就是方便传参，可以直接使用this而不是Thread.currentThread()方法
            // 缺点是不能继承其他类，任务也在线程里面没有分离。
            System.out.println(this +":"+i);
        }
    }

    public static void main(String[] args) {
        // 创建实例后并没有启动执行，直到调用start()方法才真正启动了线程
        extendsThread mThread1 = new extendsThread();
        extendsThread mThread2 = new extendsThread();
        extendsThread mThread3 = new extendsThread();
        // start()方法让线程处于就绪状态，执行完run方法后该线程就处于终止状态
        mThread1.start();
        mThread2.start();
        mThread3.start();
    }

}
