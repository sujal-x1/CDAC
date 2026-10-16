package day6;
import java.util.Scanner;
public class MyArithException extends Exception {
	public MyArithException(String message) {
		super (message);
	}
		
	}


 class Calculator{
	public double caldouble(int num) throws MyArithException {
		if (num == 0) {
			throw new MyArithException("zero not allowed");
		}
		if (num<0) {
			throw new MyArithException("negative not allowed");
		}
		return num * 2.0;
	}
}
 
 class MyCalcApp{
		public static void main(String[] args) {
			Scanner sc= new Scanner(System.in);
			
			System.out.println("enter a number");
			int num = sc.nextInt();
			
			Calculator c = new Calculator();
			try {
				double result = c.caldouble(num);
				System.out.println("Double =" + result);
			}
			catch(MyArithException e) {
				System.out.println(e.getMessage());
			}
			sc.close();
		}
 }