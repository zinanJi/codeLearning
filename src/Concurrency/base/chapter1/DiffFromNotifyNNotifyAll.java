package Concurrency.base.chapter1;

/**
 * Created by zinan.ji on 2020-04-21.
 */
public class DiffFromNotifyNNotifyAll {
    // 创建资源
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println("ThreadA get the resourceA lock");

                    try {
                        System.out.println("ThreadA begin chapter1");
                        resourceA.wait();
                        System.out.println("ThreadA end chapter1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("ThreadB get the resourceA lock");

                    try {
                        System.out.println("ThreadB begin chapter1");
                        resourceA.wait();
                        System.out.println("ThreadB end chapter1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    /*System.out.println("ThreadC begin notify");
                    resourceA.notify();*/
                    System.out.println("ThreadC begin notifyAll");
                    resourceA.notifyAll();
                }
            }
        });

        threadA.start();
        threadB.start();
        // 让main休眠1s，等到A和B都执行完wait方法。如果等到notifyAll后再wait就不会被唤醒了
        // sleep方法不参与CPU调度，但是会持有锁不让出，睡眠中被人interrupt会抛InterruptedException异常
        Thread.sleep(100);
        threadC.start();

        // 当前线程（主线程）阻塞自己，需要等待线程结束后才能继续执行
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");
    }

}
