package javacompetition;
/*
public class PrimeCount{
	public static void main(String[] args) {
		int count=0;
		int range=100;
		for(int i=2;i<=range;i++) {//2 se le k 100 tak;
			boolean isPrime=true;//default prime maan lenge
			for(int j=2;j<i;j++) {//j<i == agar i=10 tak jayega toh j bas 9
				if(i%j==0) {//since 10%2==0 toh inner forloop break with prime false;
					isPrime=false;
					break;
				}
			}
			if(isPrime) {//at end if prime count++
				count+=1;
			}
		}System.out.println(count);
	}
}*/
//next try finding out actual prime numbers not just the count

public class PrimeCount{
	public static void main(String[] args) {
		int count=0;
		 int range=100;
		 for(int i=2;i<=range;i++) {
			 boolean isPrime=true;
			 for(int j=2;j<i;j++) {
				 if(i%j==0) {
					 isPrime=false;
					 break;
				 }
			 }
			 if(isPrime) {
				 System.out.print(i);
			 }
		 }
	}
}