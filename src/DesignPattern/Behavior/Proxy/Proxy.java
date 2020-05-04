package DesignPattern.Behavior.Proxy;

/**
 * Created by zinan.ji on 2020-04-19.
 */
public class Proxy implements Subject{
    // 静态代理，用用一个被代理类的实例
    private RealSubject realSubject;
    @Override
    public void Request() {
        if (realSubject==null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }

    private void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }

    private void postRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }

}
