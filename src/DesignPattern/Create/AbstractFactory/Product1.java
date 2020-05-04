package DesignPattern.Create.AbstractFactory;

/**
 * Created by zinan.ji on 2020-04-19.
 */
interface Product1{
    public void show();
}

class ConcreteProduct11 implements Product1 {
    @Override
    public void show(){
        System.out.println("具体产品11展示...");
    }
}

class ConcreteProduct12 implements Product1
{
    @Override
    public void show()
    {
        System.out.println("具体产品12显示...");
    }
}