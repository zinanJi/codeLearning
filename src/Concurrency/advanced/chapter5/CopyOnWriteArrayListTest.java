package Concurrency.advanced.chapter5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by zinan.ji on 2020-04-27.
 */
public class CopyOnWriteArrayListTest {

    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("Swatow");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.set(1,"aloha");
                arrayList.remove(2);
                // remove是把剩余的元素复制到新数组，所以索引2变成了to
                arrayList.remove(2);
            }
        });

        // 保证在修改线程启动前获取迭代器
        Iterator<String> itr = arrayList.iterator();

        // 启动线程
        threadOne.start();

        // 等待子线程执行完毕
        threadOne.join();

        Iterator<String> itr2 = arrayList.iterator();
        System.out.println("线程执行前的迭代：");
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("线程执行后的迭代：");
        while (itr2.hasNext()){
            System.out.println(itr2.next());
        }
    }
}
