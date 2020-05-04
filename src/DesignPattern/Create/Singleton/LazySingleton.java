package DesignPattern.Create.Singleton;

/**
 * Created by zinan.ji on 2020-04-19.
 */

public class LazySingleton {
    // 类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例
    private static volatile LazySingleton instance = null;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        LazySingleton a = LazySingleton.getInstance();

    }
}

