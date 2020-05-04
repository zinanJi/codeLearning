package Concurrency.interview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zinan.ji on 2020-04-21.
 */
public class AB_Lock {
    // 通过JDK5中的Lock锁来保证线程的访问的互斥,ReentrantLock可重入，lock()后再lock()
    private static Lock lock = new ReentrantLock();
    //通过state的值来确定是否打印
    private static int state = 0;

    static class ThreadA extends Thread {
        @Override
        public void run(){
            for (int i=0;i<10;){
                try {
                    lock.lock();
                    while (state%2==0) {
                        System.out.print("A");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run(){
            for (int i =0;i<10;){
                try{
                    lock.lock();
                    while (state%2==1){
                        System.out.print("B");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
    }
}
