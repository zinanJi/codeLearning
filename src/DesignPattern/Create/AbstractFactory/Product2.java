package DesignPattern.Create.AbstractFactory;

/**
 * Created by zinan.ji on 2020-04-19.
 */
interface Product2{
    public void show();
}

class ConcreteProduct21 implements Product2 {
    @Override
    public void show(){
        System.out.println("具体产品21展示...");
    }
}

class ConcreteProduct22 implements Product2
{
    @Override
    public void show()
    {
        System.out.println("具体产品22显示...");
    }
}