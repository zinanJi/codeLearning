package Concurrency.advanced.chapter5;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by zinan.ji on 2020-04-27.
 */
public class CopyOnWriteArrayListIteratorTest {
    public static void main(String[] args) {
        // 线程安全的ArrayList，内部维护一个ReentrantLock
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        // add操作首先复制快照，然后在快照上添加，然后替换原数组
        arrayList.add("hello");
        arrayList.add("world");

        Iterator<String> itr = arrayList.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
