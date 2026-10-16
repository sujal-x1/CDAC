/*

With a Unix-domain socket, the application chooses a local filesystem path as the socket address. The client must use the same path to connect to the server.

*/


import java.net.*;
import java.nio.channels.*;
import java.nio.file.*;

public class Client
{
    public static void main(String[] args) throws Exception
    {
        Path path = Path.of("myserver.socket");

        UnixDomainSocketAddress address =
            UnixDomainSocketAddress.of(path);

        SocketChannel client =
            SocketChannel.open(StandardProtocolFamily.UNIX);

        client.connect(address);

        System.out.println("Connected to server");

        client.close();
    }
}