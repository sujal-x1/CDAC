package practicallearning;
//count and print prime
public class PrimeNorm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int range=100;
		int count=0;
		for(int i=2;i<range;i++) {
			boolean isprime=true;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					isprime=false;
					break;
				}
			}
			if(isprime) {
				System.out.println(i+"is prime");
				count+=1;
			}
		}
		System.out.println(count);
	}
}


