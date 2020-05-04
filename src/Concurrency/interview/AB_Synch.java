package Concurrency.interview;

/**
 * Created by zinan.ji on 2020-04-20.
 */
public class AB_Synch {
    public static class ThreadPrinter implements Runnable {
        private String name;
        private final Object prev;
        private final Object self;

        public ThreadPrinter(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count>0){
                // 先获取prev锁,先持有prev锁再申请self锁控制执行顺序
                synchronized (prev) {
                    // 再获取self锁
                    synchronized (self){
                        System.out.print(name);
                        count--;

                        // 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                        self.notifyAll();
                    }
                    // 执行完self同步块，self锁释放
                    try{
                        if (count ==0) prev.notifyAll();
                        // 立即释放prev锁，当前线程休眠，等待唤醒
                        else prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        ThreadPrinter pa = new ThreadPrinter("A",b,a);
        ThreadPrinter pb = new ThreadPrinter("B",a,b);
        new Thread(pa).start();
        Thread.sleep(10);
        new Thread(pb).start();
        Thread.sleep(10);
    }
}
