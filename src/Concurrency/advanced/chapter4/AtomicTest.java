package Concurrency.advanced.chapter4;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zinan.ji on 2020-04-25.
 */
public class AtomicTest {

    // 创建Long型原子计数器
    private static AtomicLong atomicLong = new AtomicLong();
    // 创建数据源
    private static Integer[] arrayOne = new Integer[]{0,1,2,3,0,5,6,0,56,0};
    // 创建数据源
    private static Integer[] arrayTwo = new Integer[]{10,1,2,3,0,5,6,0,56,0};

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayOne.length;
                for (int i = 0;i<size;i++){
                    if (arrayOne[i].intValue()==0){
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayTwo.length;
                for (int i = 0;i<size;i++){
                    if (arrayTwo[i].intValue()==0){
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();
        System.out.println("count 0:"+atomicLong.get());
    }

}
