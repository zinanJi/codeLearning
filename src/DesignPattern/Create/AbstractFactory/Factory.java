package DesignPattern.Create.AbstractFactory;

/**
 * Created by zinan.ji on 2020-04-19.
 */
interface AbstractFactory
{
    public Product1 newProduct1();
    public Product2 newProduct2();
}

class ConcreteFactory1 implements AbstractFactory
{
    public Product1 newProduct1()
    {
        System.out.println("具体工厂 1 生成-->具体产品 11...");
        return new ConcreteProduct11();
    }
    public Product2 newProduct2()
    {
        System.out.println("具体工厂 1 生成-->具体产品 21...");
        return new ConcreteProduct21();
    }
}

class ConcreteFactory2 implements AbstractFactory
{
    public Product1 newProduct1()
    {
        System.out.println("具体工厂 2 生成-->具体产品 12...");
        return new ConcreteProduct12();
    }
    public Product2 newProduct2()
    {
        System.out.println("具体工厂 2 生成-->具体产品 22...");
        return new ConcreteProduct22();
    }
}