package Concurrency.base.chapter1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zinan.ji on 2020-04-21.
 */
public class SleepHoldingLock {
    // 创建一个独占锁,该锁每一次只能被一个线程所持有。final的sync对象，每次都是CAS操作
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        // 创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                lock.lock();
                try{
                    System.out.println("child threadA is in sleep");

                    Thread.sleep(10000);

                    System.out.println("child threadA is awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                lock.lock();
                try{
                    System.out.println("child threadB is in sleep");

                    Thread.sleep(10000);

                    System.out.println("child threadB is awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();

        Thread.sleep(2000);
        // 中断睡眠线程会抛异常
        threadA.interrupt();
    }


}
