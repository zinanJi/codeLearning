package Concurrency.advanced.chapter3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by zinan.ji on 2020-04-24.
 */
public class RandomTest {
    public static void random(String[] args){
        // 创建一个默认种子的随机数生成器
        Random random = new Random();

        // 输出10个0-5（[0,5)）之间的随机数
        for (int i =0;i<10;++i){
            // nextInt方法中的next方法生成新种子为保证原子性用了CAS操作，会造成大量线程自旋
            System.out.println(random.nextInt(5));
        }
    }
    public static void main(String[] args){
        // 每个线程自己维护一个本地的种子变量
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // 输出10个0-5（[0,5)）之间的随机数
        for (int i =0;i<10;++i){
            System.out.println(random.nextInt(5));
        }

    }
}
