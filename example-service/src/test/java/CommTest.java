import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by liushuang on 2016/9/10.
 */
public class CommTest {

    public static void main(String[] args) {
        InstanceInfo nextServerInfo = DiscoveryManager.getInstance()
                .getDiscoveryClient()
                .getNextServerFromEureka("ACCOUNTS-SERVICE", false);

        Socket s = new Socket();
        int serverPort = nextServerInfo.getPort();
        try {
            s.connect(new InetSocketAddress(nextServerInfo.getHostName(),
                    serverPort));
        } catch (IOException e) {
            System.err.println("Could not connect to the server :"
                    + nextServerInfo.getHostName() + " at port " + serverPort);
        }
    }
}
