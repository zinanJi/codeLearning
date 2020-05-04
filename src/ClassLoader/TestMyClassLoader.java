package ClassLoader;

import java.lang.reflect.Constructor;

/**
 * Created by zinan.ji on 2020-04-14.
 */
public class TestMyClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = new MyClassLoader();
        classLoader.getParent();

            try {
                Class clz = classLoader.loadClass("Person");
                Constructor constructor = clz.getConstructor(String.class,int.class,String.class);
                Object obj = constructor.newInstance("jzn",24,"男");
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }


    }

}
