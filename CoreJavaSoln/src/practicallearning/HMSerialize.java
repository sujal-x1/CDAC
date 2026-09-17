package practicallearning;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Student1 implements Serializable{
	String name ;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	public Student1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
			
}
public class HMSerialize {

	public static void main(String[] args) {
		Student1 s1 = new Student1("SuJaL", 34);
		Student1 s2 = new Student1("PrAtiK", 24);
		Student1 s3 = new Student1("Manish", 94);
		
		HashMap<Integer, Student1> studentMap = new HashMap<>();
		studentMap.put(11,s1);
		studentMap.put(12,s2);
		studentMap.put(13,s3);
		
//		Serializing map
		try(
				FileOutputStream fos = new FileOutputStream("student.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				){
			oos.writeObject(studentMap);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try(FileInputStream fis=new FileInputStream("student.ser");
				ObjectInputStream ois=new ObjectInputStream(fis);){
			
			HashMap<Integer, Student1> map2=(HashMap<Integer, Student1>)ois.readObject();
			for(Map.Entry<Integer, Student1> m : map2.entrySet()) {
				System.out.println("Key : "+ m.getKey() + "\tValue : "+ m.getValue());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
