package practicallearning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*class Student implements Serializable
rollno
name

create 2 objects of Student , store them inside ArrayList and store that ArrayList inside the file.

now read from file , the ArrayList and traverse it using Iterator
*/

class Student implements Serializable{
	int rollno;
	String name;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + "]";
	}
	
}
public class PracArrSer {
	public static void main (String args[]) {
	ArrayList <Student>list = new ArrayList<>();
	Student s1= new Student();
	Student s2 = new Student();
	s1.setName("abc");
	s2.setName("gef");
	s1.setRollno(1);
	s2.setRollno(6);
	
	list.add(s1);
	list.add(s2);
	try {
		FileOutputStream fos = new FileOutputStream("PracArrSer.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		FileInputStream fis = new FileInputStream("PracArrSer.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List <Student> list2 = (List <Student>)ois.readObject();
		ListIterator itr = list2.listIterator();
		while(itr.hasNext()) 
			System.out.println(itr.next());
		
		

	} catch (FileNotFoundException e) {
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