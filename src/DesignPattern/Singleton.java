package DesignPattern;

/**
 * Created by zinan.ji on 2020-04-20.
 */
public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            return new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();

    }
}
