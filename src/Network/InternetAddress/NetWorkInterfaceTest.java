package Network.InternetAddress;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by zinan.ji on 2020-05-05.
 */
public class NetWorkInterfaceTest {
    public static void main(String[] args) throws SocketException {
        try {
            // 获取指定名字的网络接口
            NetworkInterface ni = NetworkInterface.getByName("eth0");
            if (ni==null) {
                System.out.println("No such interface:eth0");
            }
        } catch(SocketException e){
            System.out.println("Could not list sockets");
        }

        try {
            // 获取指定IP地址绑定的网络接口
            InetAddress local = InetAddress.getByName("127.0.0.1");
            NetworkInterface ni = NetworkInterface.getByInetAddress(local);
            if (ni==null) {
                System.out.println("That's weird,no local loopback 127.0.0.1");
            }
        } catch(SocketException e){
            System.out.println("Could not list network interfaces.");
        } catch (UnknownHostException e) {
            System.out.println("That's weird,Could not loopup 127.0.0.1");
        }
        
        // 获取本地主机上的所有网络接口
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
        }
        
        // 获取一个网络接口上的所有IP地址
        NetworkInterface eth0 = NetworkInterface.getByName("eth0");
        Enumeration addresses = eth0.getInetAddresses();
        while (addresses.hasMoreElements()){
            System.out.println(addresses.nextElement());
        }
    }
}
