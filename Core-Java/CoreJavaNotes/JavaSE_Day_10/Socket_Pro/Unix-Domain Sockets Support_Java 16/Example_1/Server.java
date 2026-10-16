/*

With a Unix-domain socket, the application chooses a local filesystem path as the socket address. The client must use the same path to connect to the server.

*/

import java.net.*;
import java.nio.channels.*;
import java.nio.file.*;

public class Server
{
    public static void main(String[] args) throws Exception
    {
        Path path = Path.of("myserver.socket");

        UnixDomainSocketAddress address =
            UnixDomainSocketAddress.of(path);

        ServerSocketChannel server =
            ServerSocketChannel.open(StandardProtocolFamily.UNIX);

        server.bind(address);

        System.out.println("Server started...");

        SocketChannel client = server.accept();

        System.out.println("Client connected");

        client.close();
        server.close();

        Files.deleteIfExists(path);
    }
}