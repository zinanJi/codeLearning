package Concurrency.CreateThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zinan.ji on 2020-04-20.
 */
// 实现Callable可以有返回值
public class ImplementsCallable implements Callable<Integer> {
    private int i = 0;

    @Override
    public Integer call() throws Exception {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "====" + i);
        }
        return i;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个FutureTask对象，构造函数入参为Callable的实例
        Callable<Integer> callable = new ImplementsCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "====" + i);
            if (i == 20) {
                // 创建一个以FutureTask对象为target的线程并启动
                Thread t1 = new Thread(futureTask, "有返回值的线程");
                t1.start();
            }
        }
        try {
            // 最后futureTask.get()为任务执行完毕后返回的结果值
            System.out.println("子线程返回值:" + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
