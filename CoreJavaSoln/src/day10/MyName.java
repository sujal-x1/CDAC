package day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

public class MyName implements Serializable{
	private int num;
	
	public MyName(int num) {
		this.num = num;
	}
	

	@Override
	public String toString() {
		return "MyName [num=" + num + "]";
	}


	public static void main(String[] args) {
		MyName a = new MyName(11);
		MyName a1 = new MyName(13);
		MyName a2 = new MyName(15);
		MyName a3 = new MyName(20);
		
		ArrayList <MyName> list = new ArrayList<>();
		list.add(a);
		list.add(a1);
		list.add(a2);
		list.add(a3);
		//Serializin
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("myname.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
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
				FileInputStream fis = new FileInputStream("myname.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				ArrayList <MyName> list2= (ArrayList <MyName>)ois.readObject();
				fis.close();
				ois.close();
				ListIterator<MyName> itr=list2.listIterator() ;
				while(itr.hasNext()) {
					System.out.println(itr.next());
				}

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
