package DesignPattern.Create.FactoryMethod;

/**
 * Created by zinan.ji on 2020-04-19.
 */
public class AbstractFactoryTest{
    public static void main(String[] args) {

    AbstractFactory af = new ConcreteFactory1();
    Product p = af.newProduct();
    p.show();
}

}
