package DesignPattern.Create.Builder;

/**
 * Created by zinan.ji on 2020-04-19.
 */
public class Client {
    public static void main(String[] args) {
        // 建造者（Builder）模式由产品、抽象建造者、具体建造者、指挥者等 4 个要素构成
        // 产品的组成部分是不变的，但每一部分是可以灵活选择的，由具体建造者来创建的。
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product p = director.construct();
        p.show();
    }

}
