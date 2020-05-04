package DesignPattern.Create.Prototype;

/**
 * Created by zinan.ji on 2020-04-19.
 */
// Realizetype是具体原型类，Cloneable是抽象原型类
class Realizetype implements Cloneable {
    public Realizetype() {
    }

    public Object clone() throws CloneNotSupportedException {
        return (Realizetype) super.clone();
    }

}

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype obj1 = new Realizetype();
        Realizetype obj2 = (Realizetype) obj1.clone();
        System.out.println("obj1 == obj2 ? " + (obj1 == obj2));
    }
}
