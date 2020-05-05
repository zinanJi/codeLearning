package Network.InternetAddress;

import java.net.InetAddress;
import java.util.concurrent.Callable;

/**
 * Created by zinan.ji on 2020-05-06.
 */
public class LookupTask implements Callable {
    private String line;

    public LookupTask(String line) {
        this.line = line;
    }

    @Override
    public Object call() throws Exception {
        try {
            int index = line.indexOf(' ');
            String ip = line.substring(0, index);
            String theRest = line.substring(index);
            String hostName = InetAddress.getByName(ip).getHostName();
            return hostName + " " + theRest;
        } catch (Exception e) {
            return line;
        }

    }
}
