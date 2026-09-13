package day9;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Assign2 {
		public static void main(String[]args) {
			try(RandomAccessFile rf= new RandomAccessFile("d:\\WriteandAppend.txt","rw")) {
				rf.seek(rf.length());
				System.out.println("Enter data");
				byte b[]=new byte[200];
				int k = System.in.read(b);
				rf.write(b,0,k);
				byte c[]=new byte[(int) rf.length()];
				rf.read(c);
				String ss= new String(c);
				System.out.println(ss);
				rf.seek(rf.length());
				System.out.println("Enter data again");
				k=System.in.read(b);
				rf.write(b,0,k);
				System.out.println("Reading all the data here");
				rf.seek(0);
				c=new byte[(int)rf.length()];
				rf.read(c);
				ss= new String(c);
				System.out.println(ss);
			} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
