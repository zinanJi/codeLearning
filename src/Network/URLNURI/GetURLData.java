package Network.URLNURI;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by zinan.ji on 2020-05-06.
 */
public class GetURLData {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.lolcats.com");
            try(InputStream in = u.openStream()){
                int c;
                while ((c=in.read())!= -1) System.out.write(c);
                in.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
