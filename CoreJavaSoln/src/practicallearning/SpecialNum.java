package practicallearning;

import java.util.Scanner;

public class SpecialNum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int original = n;
		int sum=0;
		while(n>0) {
			int digit = n%10;
			
			int fact=1;
			for(int i=1;i<=digit;i++) {
				fact*=i;
			}
			sum+=fact;
			n=n/10;
		}
		if(sum==original) {
			System.out.println("special");
		}
		else System.out.println("not");
	}

}
