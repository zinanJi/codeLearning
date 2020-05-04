package Concurrency.interview;

import java.util.concurrent.Semaphore;

/**
 * Created by zinan.ji on 2020-04-21.
 */
public class AB_Semaphore {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);

    static class ThreadA extends Thread {
        @Override
        public void run(){
            try{
                for (int i =0;i<10;i++){
                    A.acquire();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                    System.out.print("A");
                    B.release();// B释放信号，B信号量加1（初始为0），此时可以获取B信号量
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    B.acquire();
                    System.out.print("B");
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new ThreadA().start();
        new ThreadB().start();
    }
}
