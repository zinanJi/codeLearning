package ClassLoader;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by zinan.ji on 2020-04-14.
 */
public class TestJVM {

    @Test
    public void testClassLoader() throws Exception{
        // 通过ClassLoader.getSystemClassLoader()获取系统加载类，将类的初始化操作设置为false
        Class cl = Class.forName("ClassLoader.Person",false,ClassLoader.getSystemClassLoader());
        Field name  = cl.getDeclaredField("name");
        System.out.println(name);

        //虽然上面的代码再加载类的过程中设置禁用静态代码块的加载，通过反射获取到的时候依然会触发静态代码块的执行
        Object obj = cl.newInstance();
        name.set(obj,"jzn");
        System.out.println(obj);
    }

}
