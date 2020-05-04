package DesignPattern.Create.FactoryMethod;

/**
 * Created by zinan.ji on 2020-04-19.
 */
interface Product{
    public void show();
}

class ConcreteProduct1 implements Product {
    @Override
    public void show(){
        System.out.println("具体产品1展示...");
    }
}

class ConcreteProduct2 implements Product
{
    @Override
    public void show()
    {
        System.out.println("具体产品2显示...");
    }
}