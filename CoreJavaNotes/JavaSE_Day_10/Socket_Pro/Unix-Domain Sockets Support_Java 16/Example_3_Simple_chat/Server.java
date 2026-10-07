import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.nio.file.*;

public class Server
{
    public static void main(String[] args) throws Exception
    {
        Path path = Path.of("myserver.socket");

        // Delete old socket file if it exists
        Files.deleteIfExists(path);

        UnixDomainSocketAddress address =
            UnixDomainSocketAddress.of(path);

        ServerSocketChannel server =
            ServerSocketChannel.open(StandardProtocolFamily.UNIX);

        server.bind(address);

        System.out.println("Server started...");
        System.out.println("Waiting for client...");

        SocketChannel client = server.accept();

        System.out.println("Client connected.");

        BufferedReader reader =
            new BufferedReader(
                Channels.newReader(client, "UTF-8"));

        BufferedWriter writer =
            new BufferedWriter(
                Channels.newWriter(client, "UTF-8"));

        BufferedReader keyboard =
            new BufferedReader(
                new InputStreamReader(System.in));

        while (true)
        {
            // Server waits for client's message
            String message = reader.readLine();

            System.out.println("Client: " + message);

            // Server types response
            System.out.print("Server: ");
            String response = keyboard.readLine();

            writer.write(response);
            writer.newLine();
            writer.flush();
        }
    }
}