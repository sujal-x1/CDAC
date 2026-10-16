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

interface Product extends Serializable{
	void displayDetails();
}
public class Assign7 implements Serializable{
	
	public static void main(String args[])  {
		Assign7a ele = new Assign7a(79,"phone");
		Assign7a ele1 = new Assign7a(70,"headphones");
		Assign7a ele2 = new Assign7a(99,"pc");
		Assign7b groc = new Assign7b(10,"bhaji");
		Assign7b groc1 = new Assign7b(12,"Aloo");
		Assign7b groc2 = new Assign7b(18,"beet");
	ArrayList<Product>list = new ArrayList<>();
	list.add(ele);
	list.add(ele1);
	list.add(ele2);
	list.add(groc);
	list.add(groc1);
	list.add(groc2);
	
	FileOutputStream fos;
	try {
		fos = new FileOutputStream("Assign7.txt");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(list);
		fos.close();
		oos.close();
		/////////////////////Input////////////////////
		FileInputStream fis = new FileInputStream("Assign7.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList <Product>list2=(ArrayList<Product>)ois.readObject();
		ListIterator <Product>itr2= list2.listIterator();
		while(itr2.hasNext()) {
			Product p =itr2.next();
			p.displayDetails();
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