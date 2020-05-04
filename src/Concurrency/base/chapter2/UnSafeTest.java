package Concurrency.base.chapter2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by zinan.ji on 2020-04-22.
 */
public class UnSafeTest {
    // 获取Unsafe实例
    // 会报错，调用getUnsafe方法的class对象是UnSafeTest.class，getUnsafe会判断是不是Bootstrap加载器加载了UnSafeTest.class
    // 但是很遗憾是AppClassLoader加载器加载的
    // static final Unsafe unsafe = Unsafe.getUnsafe();
    static final Unsafe unsafe;

    // 记录变量state在类UnsafeTest中的偏移值
    static final long stateOffset;

    // 变量
    private volatile long state = 0;

    static {
        try{
            // 使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            // 将theUnsafe设置为可取
            field.setAccessible(true);

            // 获取该变量的值
            unsafe = (Unsafe) field.get(null);

            // 获取state在UnSafeTest中的偏移量
            stateOffset  = unsafe.objectFieldOffset(UnSafeTest.class.getDeclaredField("state"));

        } catch (Exception e) {
            e.printStackTrace();
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        // 创建实例，并且设置state值为1
        UnSafeTest test = new UnSafeTest();
        Boolean success = unsafe.compareAndSwapInt(test,stateOffset,0,1);
        System.out.println(success);
    }



}
