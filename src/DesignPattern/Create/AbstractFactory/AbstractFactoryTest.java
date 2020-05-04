package DesignPattern.Create.AbstractFactory;

/**
 * Created by zinan.ji on 2020-04-19.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {

        AbstractFactory af = new ConcreteFactory1();
        Product1 p11 = af.newProduct1();
        p11.show();
        Product2 p12 = af.newProduct2();
        p12.show();
    }

}