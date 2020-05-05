package Network.InternetAddress;

import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by zinan.ji on 2020-05-05.
 */
public class IPCharacteristics {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            
            InetAddress address = InetAddress.getByName(scanner.nextLine());
            // 通配地址
            if (address.isAnyLocalAddress()){
                System.out.println(address + " is a wildcard address.");
            }
            // 回送地址
            if (address.isLoopbackAddress()){
                System.out.println(address + " is a loopback address.");
            }
            // IPv6本地链接地址
            if (address.isLinkLocalAddress()){
                System.out.println(address + " is a link-local address.");
            }
            // IPv6网站地址
            else if (address.isSiteLocalAddress()){
                System.out.println(address + " is a site-local address.");
            }
            // 全球地址
            else{
                System.out.println(address + " is a global address.");
            }
            // 组播地址
            if (address.isMulticastAddress()){
                // 全球组播地址
                if (address.isMCGlobal()){
                    System.out.println(address + " is a global multicast address.");
                }
                // 组织范围组播地址
                else if (address.isMCOrgLocal()){
                    System.out.println(address + " is an organization wide multicast address.");
                }
                // 网站范围组播地址
                else if (address.isMCSiteLocal()){
                    System.out.println(address + " is a site wide multicast address.");
                }
                // 子网范围组播地址
                else if (address.isMCLinkLocal()){
                    System.out.println(address + " is a subnet wide multicast address.");
                }
                // 本地接口组播地址
                else if (address.isMCNodeLocal()){
                    System.out.println(address + " is an interface-local multicast address.");
                }
                // 未知类型组播地址
                else {
                    System.out.println(address + " is an unknown multicast address type.");
                }
            }else{
                // 单播地址
                System.out.println(address + " is a unicast address.");
            }
        }catch(Exception e){
            System.out.println("Could not resolve "+ args[0]);
        }
    }
}
