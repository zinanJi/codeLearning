package Concurrency.base.chapter1;

import java.util.ArrayList;

/**
 * Created by zinan.ji on 2020-04-21.
 */
public class ProducerConsumerForWaitTest {
    static final ArrayList<String> queue = new ArrayList();
    static class Producer extends Thread{


        @Override
        public void run() {
            synchronized (queue) {
                // 消费队列满，则等待队列空闲
                while (queue.size()==MAX_PRIORITY){
                    try {
                        // 挂起当前线程，并释放通过同步块获取的queue上的锁，让消费者进程可以获取锁，然后获取队列里的元素
                        System.out.println("product满了生产不了");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add("product");
                queue.forEach(System.out::println);
                queue.notifyAll();
            }
        }
    }

    static class Consumer extends Thread{
        @Override
        public void run() {
            synchronized (queue){
                // 消费队列为空
                while (queue.size()==0){
                    try {
                        // 挂起当前线程，并释放通过同步块获取的queue上的锁，让生产者进程可以获取锁，将生产元素放入队列
                        System.out.println("还没有product可以取");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 消费元素
                queue.remove("product");
                if (queue.size()==0) System.out.println("取光了");
                queue.notifyAll();
            }
        }
    }

    public static void main(String[] args){
        Producer p = new Producer();
        Consumer c = new Consumer();

        c.start();
        p.start();

    }
}
