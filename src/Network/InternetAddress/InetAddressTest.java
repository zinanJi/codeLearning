package Network.InternetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * Created by zinan.ji on 2020-04-28.
 */
public class InetAddressTest {


    public static void main(String[] args){
        try {
            InetAddress address = InetAddress.getByName("www.baidu.com");
            System.out.println(address);

            InetAddress[] addressList = InetAddress.getAllByName("www.baidu.com");
            for (InetAddress addr:addressList){
                System.out.println(addr);
            }

            InetAddress me = InetAddress.getLocalHost();
            System.out.println(me);

            // 把点分四段地址转化为主机名
            InetAddress ia = InetAddress.getByName("172.20.10.8");
            System.out.println(ia.getCanonicalHostName());

            String dottedQuad = me.getHostAddress();
            System.out.println("My address is "+ dottedQuad);

            // 查看地址是ipv4还是ipv6
            byte[] addr = ia.getAddress();
            if (addr.length==4) System.out.println(ia+" is ipv4");
            else if (addr.length==16)System.out.println(ia+" is ipv6");
            else System.out.println(ia+"is bool shit");
        } catch (UnknownHostException e) {
            System.out.println("could not find the address");
            e.printStackTrace();
        }

    }
}
