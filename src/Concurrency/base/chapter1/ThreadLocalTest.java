package Concurrency.base.chapter1;

import sun.misc.Unsafe;

/**
 * Created by zinan.ji on 2020-04-22.
 */
// ThreadLocal的基本使用
public class ThreadLocalTest {

    // print函数
    static void print(String str) {
        // 打印当前线程本地内存中localVariable变量的值
        System.out.println(str + ":" + localVariable.get());
        // 清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static InheritableThreadLocal<String> inheritableThreadLocalVariable = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("ThreadOne local variable");
                print("threadOne");
                System.out.println("ThreadOne remove after" + ":" + localVariable.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("ThreadTwo local variable");
                print("threadTwo");
                System.out.println("ThreadTwo remove after" + ":" + localVariable.get());
            }
        });

        threadOne.start();
        threadTwo.start();
    }

    // 不支持继承性Test
    public static void test(String[] args) {
        localVariable.set("hello world");
        inheritableThreadLocalVariable.set("hello world");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread localVariable:" + localVariable.get());
                System.out.println("thread inheritableThreadLocalVariable:" + inheritableThreadLocalVariable.get());
            }
        });
        thread.start();
        System.out.println("main localVariable:" + localVariable.get());
        System.out.println("main inheritableThreadLocalVariable:" + inheritableThreadLocalVariable.get());

    }

}
