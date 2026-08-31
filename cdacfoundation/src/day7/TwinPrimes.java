package day7;

public class TwinPrimes {
//print all prime number between 2 to 20
	public static void main(String[] args) {
		for(int i=2;i<=20;i++) {
			if (isPrime(i)&&isPrime(i+2)&&(i+2)<=20) {
				System.out.println("("+i+","+(i+2)+")");
			}
		}
	}
	public static Boolean isPrime(int no) {
		int n=no/2;
		for(int i=2;i<=n;i++) {
			if (no%i==0)
				return false;
		}
		return true;
	}

}
