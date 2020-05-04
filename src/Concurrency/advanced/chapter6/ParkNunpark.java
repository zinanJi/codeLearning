package Concurrency.advanced.chapter6;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by zinan.ji on 2020-04-27.
 */
public class ParkNunpark {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");

                // 调用park，挂起自己
                LockSupport.park();

                System.out.println("child thread unpark!");
            }
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("main thread begin unpark");

        // 调用unpark方法让thread线程持有许可证，然后park方法返回
        LockSupport.unpark(thread);
    }
}
