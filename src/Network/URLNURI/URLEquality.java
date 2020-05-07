package Network.URLNURI;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zinan.ji on 2020-05-06.
 */
public class URLEquality {
    public static void main(String[] args) throws MalformedURLException {
        URL www = new URL("http://www.ibiblio.org/");
        URL ibiblio = new URL("http://ibiblio.org/");
        if (ibiblio.equals(www)){
            System.out.println(ibiblio + " is the same as "+ www);
        } else {
            System.out.println(ibiblio + " is not the same as " + www);
        }

        // sameFile方法不考虑片段标识符
        URL u1 = new URL("http://www.ncsa.uiuc.edu/HTMLPrimer.html#GS");
        URL u2 = new URL("http://www.ncsa.uiuc.edu/HTMLPrimer.html#HD");
        
        if (u1.equals(u2)){
            System.out.println(u1 + " is the same as \n"+ u2);
        } else {
            System.out.println(u1 + " is not the same as \n" + u2);
        }
        
        if (u1.sameFile(u2)){
            System.out.println(u1 + " is the same file as \n"+ u2);
        } else {
            System.out.println(u1 + " is not the same file as \n"+ u2);
        }
    }
}
