package Concurrency.base.chapter1;

/**
 * Created by zinan.ji on 2020-04-22.
 */
public class DeadLockTest {
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("ThreadA get the resourceA lock");

                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+" is waiting get resourceB");
                    synchronized (resourceB){
                        System.out.println("ThreadA get the resourceB lock");
                    }
                }

            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                // 请求并持有、两个互斥资源、形成环路等待、也不可剥夺
                // synchronized (resourceB){
                // 保持资源分配有序性就能避免，线程获取了资源n-1时才能获取资源n
                synchronized (resourceA){
                    System.out.println("ThreadB get the resourceA lock");

                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+" is waiting get resourceB");
                     // synchronized (resourceA){
                    synchronized (resourceB){
                        System.out.println("ThreadB get the resourceB lock");
                    }
                }

            }
        });

        threadA.start();
        threadB.start();

    }

}
