package day9;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class assign4 {
	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			FileOutputStream fos = new FileOutputStream("d:\\assign4.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			int i;
			do {
				System.out.println("Enter a number");
				i=sc.nextInt();
				if(i !=0) {
					dos.writeInt(i);
				}
			}while(i!=0);
			dos.close();
			
			//open file and read nums
			FileInputStream fis = new FileInputStream("assign4.txt");
			DataInputStream dis = new DataInputStream(fis);
			
			System.out.println("Numbers in file");
			while (dis.available()!=0) {
				System.out.println(dis.readInt());
			}
			dis.close();
			sc.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	


