package Concurrency.advanced.chapter6;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by zinan.ji on 2020-04-27.
 */
public class LockSupportTest {
    public static void main(String[] args) {
        System.out.println("begin park!");

        // 使当前线程获取到许可证
        LockSupport.unpark(Thread.currentThread());
        // 有许可证的park直接返回，没有会阻塞
        LockSupport.park();

        System.out.println("end park!");
    }
}
