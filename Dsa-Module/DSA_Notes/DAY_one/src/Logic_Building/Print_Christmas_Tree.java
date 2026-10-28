package Logic_Building;

import java.util.Scanner;

public class Print_Christmas_Tree {
			static void printTree(int n) {
				for(int space=n,i=1;space>=1 && i<=n;space--,i++)
		        {
		            //space print
		            for(int s=1;s<=space;s++)
		                System.out.print(" ");
		            for(int j=1;j<=i;j++)//printer
		                System.out.print("X ");
		            System.out.print("\n");//AFTER A LINE
		        }
		    }
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		printTree(n);
	}

}
//
//If I have a program to print a Christmas tree of size `n`, `n` given by the user 
//The printing will be done using a separate function called `print_christmas_tree`. 
