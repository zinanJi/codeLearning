package DesignPattern.Create.FactoryMethod;


interface AbstractFactory
{
    public Product newProduct();
}

class ConcreteFactory1 implements AbstractFactory{
    @Override
    public Product newProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 implements AbstractFactory{
    @Override
    public Product newProduct() {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}



