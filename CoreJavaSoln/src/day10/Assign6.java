package day10;

import java.util.ArrayList;
import java.util.ListIterator;

public class Assign6 {
	int id;
	String name;
	int age;
	double marks;
	
	public Assign6(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	@Override
	public String toString() {
		return  "[id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Assign6> list = new ArrayList<>();
		Assign6 a = new Assign6(11, "john");
		Assign6 a2 = new Assign6(15, "kilo");
		a2.marks=80.25;
		Assign6 a3 = new Assign6(22, "yolo");
		
		list.add(a);
		list.add(a2);
		list.add(a3);
		System.out.println(list);
		ListIterator <Assign6>itr = list.listIterator();
		while(itr.hasNext()) {
			Assign6 obj = itr.next();
			if(obj.id==15) {
				System.out.println(obj);
			}
		}
	}

}
