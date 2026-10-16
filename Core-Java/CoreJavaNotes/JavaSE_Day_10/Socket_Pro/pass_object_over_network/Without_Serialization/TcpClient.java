import java.io.*;
import java.net.*;
import java.util.*;

public class TcpClient
{
    public static void main(String args[])
    {
        try
        {
            Socket ss = new Socket("LAPTOP-V206BP38", 10000);

            BufferedReader keyboard =
                new BufferedReader(new InputStreamReader(System.in));

            BufferedWriter writer =
                new BufferedWriter(
                    new OutputStreamWriter(ss.getOutputStream()));

            List<String> mylist = new ArrayList<>();

            System.out.println(
                "Enter book names, type quit to stop");

            while (true)
            {
                String str = keyboard.readLine();

                if (str.equalsIgnoreCase("quit"))
                    break;

                mylist.add(str);
            }

            // Send the size of the list first
            writer.write(String.valueOf(mylist.size()));
            writer.newLine();

            // Send every element of the list
            for (String book : mylist)
            {
                writer.write(book);
                writer.newLine();
            }

            writer.flush();

            ss.close();
        }
        catch(Exception ee)
        {
            System.out.println(ee);
        }
    }
}