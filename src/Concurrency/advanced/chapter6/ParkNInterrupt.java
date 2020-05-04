package Concurrency.advanced.chapter6;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by zinan.ji on 2020-04-27.
 */
public class ParkNInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");

                while (!Thread.currentThread().isInterrupted()){
                    LockSupport.park();
                }

                System.out.println("child thread end park!");

            }
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("main thread begin unpark!");

        // 中断子线程
        thread.interrupt();
    }
}
