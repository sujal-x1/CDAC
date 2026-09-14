package day10;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
/*
 * 1) accept 10 numbers from user and add them inside the ArrayList.
using ListIterator display all the numbers bidirectionally.
 */
public class Assign1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num;
		ArrayList <Integer> list = new ArrayList<>();
		System.out.println("enter 10 nums");
		for(int i=1;i<=10;i++) {
			num = sc.nextInt();
			list.add(num);
		}
		ListIterator <Integer> itr = list.listIterator();
		System.out.println();
		while(itr.hasNext())
		System.out.println(itr.next());
		
	}

}
