package day9;
import java.util.Scanner ;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = new FileOutputStream("d:\\assign1.txt");
			String enter= "hello ";
			fos.write(enter.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
