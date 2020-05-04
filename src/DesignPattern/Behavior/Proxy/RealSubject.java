package DesignPattern.Behavior.Proxy;

/**
 * Created by zinan.ji on 2020-04-19.
 */
//真实主题
class RealSubject implements Subject
{
    @Override
    public void Request()
    {
        System.out.println("访问真实主题方法...");
    }
}
