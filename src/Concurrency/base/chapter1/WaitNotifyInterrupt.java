package Concurrency.base.chapter1;

/**
 * Created by zinan.ji on 2020-04-21.
 */
// 当一个线程调用共享资源对象的wait方法阻塞挂起后，如果其他线程中断该线程，则该线程会抛出InterruptedException异常并返回
public class WaitNotifyInterrupt {
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("-- begin --");
                try{
                synchronized (obj) {
                    obj.wait();
                }
                System.out.println("-- end --");
            } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        Thread.sleep(100);
        System.out.println("--begin interrupt threadA--");
        threadA.interrupt();
        System.out.println("--end interrupt threadA--");
    }

}
