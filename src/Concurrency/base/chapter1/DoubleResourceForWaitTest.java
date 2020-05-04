package Concurrency.base.chapter1;

/**
 * Created by zinan.ji on 2020-04-21.
 */
// 调用共享资源的wait()方法时，当前线程只会释放当前共享对象的锁，持有的其他对象锁不会被释放
public class DoubleResourceForWaitTest {
    // 创建资源A和B
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();


    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    // 获取resourceA共享资源的监视器锁（synchronized同步代码块底层就是设置monitor，修饰方法是使用ACC_SYNCHRONIZED标识）
                    synchronized (resourceA) {
                        System.out.println("ThreadA get resourceA lock");
                        // 获取获取resourceB共享资源的监视器锁
                        synchronized (resourceB) {
                            System.out.println("ThreadA get resourceB lock");

                            // 线程A阻塞，并释放获取到的resourceA锁
                            System.out.println("ThreadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    // 获取resourceA共享资源的监视器锁
                    synchronized (resourceA){
                        System.out.println("ThreadB get resourceA lock");

                        System.out.println("ThreadB try to get resourceB lock...");
                        synchronized (resourceB){
                            System.out.println("ThreadB get resourceB lock");

                            // 线程A阻塞，并释放获取到的resourceA锁
                            System.out.println("ThreadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();

        // 等待两个线程结束
        threadA.join();
        threadB.join();
        System.out.println("main over");
    }
}
