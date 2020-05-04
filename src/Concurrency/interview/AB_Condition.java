package Concurrency.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zinan.ji on 2020-04-21.
 */
public class AB_Condition {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();

    private static int count =0;

    static class ThreadA extends Thread {
        @Override
        public void run(){
            try{
                lock.lock();
                for (int i = 0;i<10;i++){
                    while(count%2!=0) A.await();
                    System.out.print("A");
                    count++;
                    B.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

    }

    static class ThreadB extends Thread {
        @Override
        public void run(){
            try{
                lock.lock();
                for (int i = 0;i<10;i++){
                    while(count%2!=1) B.await();
                    System.out.print("B");
                    count++;
                    A.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadA().start();
        new ThreadB().start();
    }
}
