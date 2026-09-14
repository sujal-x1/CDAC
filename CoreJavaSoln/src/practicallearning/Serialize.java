package practicallearning;

import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {
	public static void main(String args[]) {
		UserMain user = new UserMain();
		user.name="joke";
		user.pass="joke123";
		try {
			FileOutputStream fos = new  FileOutputStream("serial.ser");
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			oos.writeObject(user);
			fos.close();
			oos.close();
			System.out.println("serialized");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
