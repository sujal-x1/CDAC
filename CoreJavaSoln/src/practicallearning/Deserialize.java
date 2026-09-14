package practicallearning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis;
		try {
			UserMain user=null;
			fis = new FileInputStream("D:\\CDAC\\CoreJavaSoln\\serial.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			user=(UserMain)ois.readObject();
			ois.close();
			fis.close();
			System.out.println(user.name);
			System.out.println(user.pass);

			
			

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
