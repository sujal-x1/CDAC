package practicallearning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class IccRanking implements Serializable {
	int rank;
	String name;
	IccRanking(int rank,String name){
		this.rank =rank;
		this.name = name;
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		// TODO Auto-generated method stub
		HashMap<Integer,String>map = new HashMap<>();
		map.put(1, "Rohit Sharma");
        map.put(2, "Virat Kohli");
        map.put(3, "Babar Azam");
        map.put(4, "Joe Root");
        map.put(5, "Steve Smith");
        FileOutputStream fos;
		try {
			fos = new FileOutputStream("iccRanking.ser");
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(map);
	        fos.close();
	        oos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("iccRanking.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashMap<Integer,String>map2 = (HashMap<Integer,String>)ois.readObject();
			System.out.println("search for a user");
			int search =sc.nextInt();
			if(map2.containsKey(search)) {
				System.out.println(search+" i got "+map2.get(search));
			}
			else System.out.println("invalid");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
		

	
		


