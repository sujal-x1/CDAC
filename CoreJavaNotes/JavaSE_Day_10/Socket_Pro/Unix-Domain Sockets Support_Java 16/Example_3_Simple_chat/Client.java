import java.io.*;
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

        System.out.println("Connected to server.");

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
            // Client types message
            System.out.print("Client: ");
            String message = keyboard.readLine();

            writer.write(message);
            writer.newLine();
            writer.flush();

            // Client waits for server's response
            String response = reader.readLine();

            System.out.println("Server: " + response);
        }
    }
}