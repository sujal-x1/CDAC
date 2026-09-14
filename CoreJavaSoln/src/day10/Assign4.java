package day10;

import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * 4) add 5 numbers inside CopyOnWriteArrayList 
 * and show how can you add one more number at 
 * the same time of traversal through its iterator.

 */
public class Assign4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyOnWriteArrayList <Integer>list= new CopyOnWriteArrayList<>();
		list.add(22);
		list.add(25);
		list.add(44);
		list.add(55);
		list.add(58);
		list.add(57);
		ListIterator<Integer> itr= list.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			list.add(0);
		}
		System.out.println(list);
	}
}


