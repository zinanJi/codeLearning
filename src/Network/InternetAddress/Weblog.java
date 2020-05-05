package Network.InternetAddress;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zinan.ji on 2020-05-06.
 */
public class Weblog {
    public static void main(String[] args) {
        try (FileInputStream fin = new FileInputStream(args[0])) {
            Reader in = new InputStreamReader(fin);
            BufferedReader bin = new BufferedReader(in);
            for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);

                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + theRest);

                } catch (UnknownHostException e) {
                    System.out.println(entry);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
