package Concurrency.base.chapter1;

/**
 * Created by zinan.ji on 2020-04-21.
 */
public class InterfaceTestImpl implements InterfaceTest {
    @Override
    public void lbwnb() {
        System.out.println("从现在开始这里是卢本伟广场");
    }

    public static void main(String[] args){
        InterfaceTestImpl test = new InterfaceTestImpl();
        test.lbwnb();
    }
}
