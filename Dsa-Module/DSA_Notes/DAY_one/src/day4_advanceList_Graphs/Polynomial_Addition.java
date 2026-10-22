package day4_advanceList_Graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class Polynomial_Addition {
	
	static LinkedList<Polynomial>list = new LinkedList<>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int power;
		System.out.println("\n Ener highest power");
		power = sc.nextInt()	;
		for(int i = power ; i>=0;i--) {
			System.out.println("for x^ "+i+"coefficient:");
			float coefficient = sc.nextFloat();
			if(coefficient!=0) {
				list.add(new Polynomial(coefficient,i));
			}
		}
	}

}
