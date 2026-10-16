package practicallearning;

public class TwinPrime {

	public static void main(String[] args) {

		int range=100;
		for(int i=2;i<range;i++) {
			boolean isPrime=true;
			boolean isPrime2=true;
			
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					isPrime=false;
					break;
				}
			}
				for(int j=2;j<i+2;j++) {
					if((i+2)%j==0) {
						isPrime2=false;
						break;
					}
			}
				if(isPrime && isPrime2) {
					System.out.println("["+i+"and"+(i+2)+"]");
				}
		}
	}

	}

