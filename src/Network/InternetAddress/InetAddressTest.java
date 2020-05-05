package Network.InternetAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * Created by zinan.ji on 2020-04-28.
 */
public class InetAddressTest {
    
    public static void main(String[] args){
        try {
            // 域名->ip地址(第一个)
            InetAddress address = InetAddress.getByName("www.baidu.com");
            System.out.println(address);

            // 域名->ip地址(所有)
            InetAddress[] addressList = InetAddress.getAllByName("www.baidu.com");
            for (InetAddress addr:addressList){
                System.out.println(addr);
            }

            // 查找本地机器的地址
            InetAddress me = InetAddress.getLocalHost();
            System.out.println(me);

            // 给定地址，把点分四段地址转化为主机名
            InetAddress ia = InetAddress.getByName("172.20.10.8");
            System.out.println(ia.getCanonicalHostName());

            // 找到本地机器地IP地址
            String dottedQuad = me.getHostAddress();
            System.out.println("My address is "+ dottedQuad);

            // 查看地址是ipv4还是ipv6
            byte[] addr = ia.getAddress();
            if (addr.length==4) System.out.println(ia+" is ipv4");
            else if (addr.length==16)System.out.println(ia+" is ipv6");
            else System.out.println(ia+"is bool shit");
            
            InetAddress local = InetAddress.getByName("127.0.0.1");
            // 测试可达性
            if (local.isReachable(1000)){
                System.out.println("www.baidu.com is reachable");
            }
            
            // InetAddress类的equals方法不要求对象有相同的主机号，类型相同，地址IP相同，散列码相同就true
            InetAddress ibiblio = InetAddress.getByName("127.0.0.1");
            InetAddress helios = InetAddress.getByName("localhost");
            if (ibiblio.equals(helios)) {
                System.out.println("127.0.0.1 is the same as localhost");
            } else {
                System.out.println("127.0.0.1 is not the same as localhost");
            }
            
        } catch (UnknownHostException e) {
            System.out.println("could not find the address");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
