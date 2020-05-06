package Network.URLNURI;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zinan.ji on 2020-05-06.
 */
public class SourceViewer {
    // 假定URL指向文本，页面可能指向其他内容资源
    public static void main(String[] args) {
        if (args.length>0){
            InputStream in = null;
            try{
                URL u = new URL(args[0]);
                in = u.openStream();
                // 缓冲输入提高性能
                in = new BufferedInputStream(in);
                // 串链到一个Reader
                Reader r = new InputStreamReader(in);
                int c;
                while ((c= r.read())!= -1) System.out.print(((char) c ));
            } catch (MalformedURLException e){
                System.out.println(args[0]+" is not a parseable URL");
            }
            catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (in !=null){
                    try {
                        in.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
