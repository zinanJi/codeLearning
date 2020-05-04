package Concurrency.advanced.chapter10;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zinan.ji on 2020-05-01.
 */
public class JoinCountDownLatch {
    // 同步信号量为2
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("child threadOne over!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 让countDownLatch内部的计数器-1，所有的线程执行完毕后调用countDown()方法后计数器减少为0，主线程的await()方法才会返回
                    countDownLatch.countDown();
                }
            }
        });


        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("child threadTwo over!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 让countDownLatch内部的计数器-1，所有的线程执行完毕后调用countDown()方法后计数器减少为0，主线程的await()方法才会返回
                    countDownLatch.countDown();
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over!");

        countDownLatch.await();

        System.out.println("all child thread over!");

    }


}
