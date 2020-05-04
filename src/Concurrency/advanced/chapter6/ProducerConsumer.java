package Concurrency.advanced.chapter6;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;

/**
 * Created by zinan.ji on 2020-04-27.
 */
public class ProducerConsumer {
    final static NonReentrantLock lock = new NonReentrantLock();
    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty = lock.newCondition();

    final static Queue<String> queue = new LinkedBlockingDeque<>();
    final static int queueSize = 10;

    public static void main(String[] args) {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    while (queue.size()==queueSize){
                        notEmpty.await();
                    }
                    queue.add("ele");
                    System.out.println("生产者生产1个"+"ele");
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    while (0==queue.size()){
                        notFull.await();
                    }
                    String ele = queue.poll();
                    System.out.println("消费者消费1个"+ele);
                    notEmpty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        producer.start();
        consumer.start();
    }

}
