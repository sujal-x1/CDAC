import java.io.*;
import java.net.*;

public class TcpServer
{
    public static void main(String args[])
    {
        try
        {
            ServerSocket sc = new ServerSocket(10000);

            Socket ss = sc.accept();

            BufferedReader reader =
                new BufferedReader(
                    new InputStreamReader(ss.getInputStream()));

            System.out.println("Books ordered by client:");

            while (true)
            {
                String book = reader.readLine();

                if (book == null)
                {
                    break;
                }

                System.out.println(book);
            }

            ss.close();
            sc.close();
        }
        catch(Exception ee)
        {
            System.out.println(ee);
        }
    }
}