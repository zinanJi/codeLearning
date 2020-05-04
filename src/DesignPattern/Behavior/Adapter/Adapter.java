package DesignPattern.Behavior.Adapter;

/**
 * Created by zinan.ji on 2020-04-19.
 */
//类适配器类
class Adapter extends Adaptee implements Target {
    public void request() {
        specificRequest();
    }
}