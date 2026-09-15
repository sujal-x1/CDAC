package day10;

import java.util.ArrayList;
import java.util.ListIterator;

public class Animal {
	public void makesound() {
		System.out.println("RandomRawr!!!");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Animal();
		Dog d = new Dog();
		Cat c = new Cat();
		
		ArrayList<Animal> list = new ArrayList<>();
		list.add(d);
		list.add(c);
		list.add(a);
		ListIterator <Animal>itr = list.listIterator();
		while(itr.hasNext()) {
			itr.next().makesound();
		}
	}

}
