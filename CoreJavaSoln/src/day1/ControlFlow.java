package day1;
import java.util.Scanner;

public class ControlFlow {
/*
	public static void main(String[] args) {
		//1)	display a table of a particular number           
		Scanner scanner=new Scanner(System.in);
		int num1=scanner.nextInt();
		for(int i=1;i<=10;i++) {
			System.out.println(num1+"*"+ i+"="+num1*i);
		}
	}

}*/
/*
public class ControlFlow {
	public static void main(String[] args) {
		//2)	declare two numbers and one operator as a character. e.g. '+'
	//using switch... case check which operator is declared and accordingly perform the action.		Scanner scanner=new Scanner(System.in);
		Scanner scanner=new Scanner(System.in);
		int num1=scanner.nextInt();
		int num2=scanner.nextInt();
		System.out.println("enter operator");
		char operator=scanner.next().charAt(0);
		switch(operator) {
		case '+':
			System.out.println(num1+num2);
			break;
		case '-':
			System.out.println(num1-num2);
			break;
		case '*':
			System.out.println(num1*num2);
			break;
		case '%':
			System.out.println(num1%num2);
			break;
		}
		
	}
}*/
//Display numbers  1 to 10 using loop
/*
public class ControlFlow {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int i;
		for(i=1;i<=10;i++) {
			System.out.println(i);
		}
	}
}*/
//4)	Display numbers from 3 to 30 except number 24  using loop.
/*
public class ControlFlow {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int i;
		for(i=3;i<=30;i++) {
			if(i==24) {
				continue;
			}
			System.out.println(i);
		}
	}
}*/
//5)	Using if…….else if….  Else,  display whether result is  fail, pass, second class , first class, Distinction etc.  
/*public class ControlFlow {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int no=scanner.nextInt();
		if(no>=75) {
			System.out.println("Distinction");
		}
		else if(no>=60) {
			System.out.println("first class");
		}
		else if(no>=50) {
			System.out.println("second class");
		}

		else if(no>=40) {
			System.out.println("pass");
		}
		else System.out.println("fail");

	}
}*/
//6) display all prime numbers between 3 to 30
/*public class ControlFlow {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int i;
		for(i=3;i<=30;i++) {
			boolean isPrime=true;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					isPrime=false;
					break;
				}
			}
			if(isPrime) {
				System.out.println(i);
			}
		}
		
	}
	
}*/
//7) using nested for loop display following :
/*public class ControlFlow {
	public static void main(String[] args) {
		for(char i='A';i<='C';i++) {
			for(char j='a';j<='c';j++) {
				System.out.println(i+""+j);
			}
			System.out.println();

		}
	}
}*/
/*
//8) accept a number and display whether it is prime or not.
	public class ControlFlow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no= sc.nextInt();
		if (no%2==0) {
			System.out.println("isPrime");
		}
		else {
			System.out.println("not prime");
		}
	}
}*/
/*
 * 9) solve following patten programs:


    * 
   * * 
  * * * 
 * * * * 
* * * * * 
 */
/*
	public class ControlFlow {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int i,j;
			for(i=1;i<=5;i++) {
				for(j=1;j<=5-i;j++) {
					System.out.print(" ");
				}
				for(int )
			}
			System.out.println();
	}
	*/
}

	