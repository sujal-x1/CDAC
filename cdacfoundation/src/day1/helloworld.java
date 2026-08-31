package day1;
//reverse a string
/*
import java.util.Scanner;
public class helloworld {
	public static void main(String[] args) {
		int no,rev=0,res;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number to reverse");//123
		no=sc.nextInt();
		while(no!=0) {
			res=no%10;//3
			rev=rev*10+res;//0+3//3*10=30+2=32//320+1=321
			no=no/10;//12
		}
		System.out.println(rev);

		sc.close();
	}
}*/
//palindrome or nah
/*
import java.util.Scanner;
public class helloworld {
	public static void main(String[] args) {
		int no,rev=0,res,palin;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number to check palindrome");//123
		no=sc.nextInt();
		palin=no;
		while(no!=0) {
			res=no%10;//3
			rev=rev*10+res;//0+3//3*10=30+2=32//320+1=321
			no=no/10;//12
		}
		if (palin==rev)
			System.out.println("is a palin");
		else {
			System.out.println("not a palin");
		}
		System.out.println(rev);

		sc.close();
	}
}*/
//accept num and print table of that then print table till that num vertical

import java.util.Scanner;
public class helloworld {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no,i,j;
		int temp;
		System.out.println("enter a number ");//123
		no=4;
		temp=no;
		for(i=1;i<=temp;i++) {
			temp=temp-1;
			System.out.print("1");
			for(j=1;j<=temp;j++) {
			}
			System.out.println();
		}
		sc.close();
	}
}
/*
     *
    **
   ***
  ****
******
*/