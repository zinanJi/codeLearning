package DesignPattern.Create.Singleton;

/**
 * Created by zinan.ji on 2020-04-19.
 */
public class HungrySingleton {
    // 类创建的同时就已经创建好一个静态的对象供系统使用
    private static final HungrySingleton instance=new HungrySingleton();

    public HungrySingleton() {
    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}
