package day10;

import java.util.LinkedList;

/*
 * 3) create LinkedList with the values 10,20,30 and 40.
display it.
now insert 500 in the beginning.
	insert 400 at 2nd position.
	add 1000 at the end.
display the list again.

 */
public class Assign3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		System.out.println(list);
		list.add(0,500);
		list.add(2,400);
		list.add(list.size(),500);
		System.out.println("******************");
		System.out.println(list);
	}

}
