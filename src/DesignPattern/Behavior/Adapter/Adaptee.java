package DesignPattern.Behavior.Adapter;

/**
 * Created by zinan.ji on 2020-04-19.
 */
//适配者接口
class Adaptee {
    public void specificRequest()
    {
        System.out.println("适配者中的业务代码被调用！");
    }
}
