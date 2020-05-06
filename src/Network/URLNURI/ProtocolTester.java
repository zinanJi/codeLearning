package Network.URLNURI;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zinan.ji on 2020-05-06.
 */
public class ProtocolTester {
    // 测试虚拟机是否支持协议
    private static void testProtocol(String url) {
        // 从字符串构造URL
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol()+" is supported");
        } catch (MalformedURLException e) {
            String protocol = url.substring(0,url.indexOf(":"));
            System.out.println(protocol+" is not supported");
        }
    }
    
    public static void main(String[] args) {
        // 超文本传输协议
        testProtocol("http://www.baidu.com");
        
        // 安全http
        testProtocol("https://www.amazon.com/exec/obios/order2/");
        
        // 文件传输协议
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq");
        
        // 简单邮件传输协议
        testProtocol("mailto:elharo@ibiblio.org");
        
        // telnet
        testProtocol("telnet://dibner.poly.edu/");
        
        // 本地文件访问
        testProtocol("file:///etc/passwd");
        
        // gopher
        testProtocol("gopher://gopher.anc.org.za/");
        
        // 轻量组目录访问协议
        testProtocol("ldap://ldap.itd.umich.edu/balabala");
        
        // JAR
        testProtocol("jar:http://balabala");
        
        // NFS，网络文件系统
        testProtocol("nfs://balabala");
        
        // JDBC定制协议 java.sql包支持
        testProtocol("jdbc:mysql://balabala:3306/");
        
        // rmi，远程方法调用的定制协议 java.rmi包支持
        testProtocol("rmi://balabala/method");
        
        // HotJava的定制协议
        testProtocol("dod:/UserGuide/release.html");
        testProtocol("netdoc:/UserGuide/release.html");
        testProtocol("systemresource://www.abc.com/+/index.html");
        testProtocol("verbatim:http://www.abc.com");
    }
}
