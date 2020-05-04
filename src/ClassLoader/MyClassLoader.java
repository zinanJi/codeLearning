package ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * Created by zinan.ji on 2020-04-14.
 */
public class MyClassLoader extends ClassLoader {
    protected Class<?> findClass(String name) {
        try {
            String path = "D:\\Workspace\\leetcode\\src\\ClassLoader\\"+name+".class";
            FileInputStream in = new FileInputStream(path);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int length = -1;
            while ((length = in.read(buf))!=-1){
                byteArrayOutputStream.write(buf,0,length);
            }
            in.close();
            byte[] classBytes = byteArrayOutputStream.toByteArray();
            return defineClass(classBytes,0,classBytes.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
