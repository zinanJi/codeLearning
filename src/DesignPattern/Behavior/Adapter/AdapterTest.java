package DesignPattern.Behavior.Adapter;

/**
 * Created by zinan.ji on 2020-04-19.
 */
public class AdapterTest {
    public static void main(String[] args)
    {
        System.out.println("类适配器模式测试：");
        Target target = new Adapter();
        target.request();
    }
}
