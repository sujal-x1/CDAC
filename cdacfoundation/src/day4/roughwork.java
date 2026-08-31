package day4;
import java.util.Scanner;
public class roughwork {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		
		primeornah(num);
	}
	
	public static void primeornah(int num) {
		int n=num/2;
		int i;
		boolean isPrime=true;
		for(i=2;i<=n;i++) {
			if(num%i==0) {
				isPrime=false;
				break;
			}
		}
		if(isPrime) {
			System.out.println("is a prime");
		}
		else {
			System.out.println("not a prime");
		}

		
	}

}
