package day10;
import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
public class Assign5a {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Assign5 a = new Assign5(21);
		Assign5 a1 = new Assign5(22);
		Assign5 a2 = new Assign5(23);
		Assign5 a3 = new Assign5(24);
		ArrayList <Assign5> list = new ArrayList<>();
		list.add(a);
		list.add(a1);
		list.add(a2);
		list.add(a3);
		FileOutputStream fos = new FileOutputStream("day10assign5.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		fos.close();
		oos.close();
		FileInputStream  fis = new FileInputStream("day10assign5.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList <Assign5> list2 = (ArrayList<Assign5>)ois.readObject();
		ois.close();
		fis.close();
		ListIterator<Assign5> itr = list2.listIterator();
		while(itr.hasNext()) {
			Assign5 obj =  itr.next();
			System.out.println(obj);
		}
	}

}
