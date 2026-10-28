package Logic_Building;

public class LargestNsmallestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int largest=0 , smallest=9,temp;
		int num=123;
		while(num!=0) {
			temp = num%10;
			if(temp>largest) {
				largest=temp;
			}
			else if (temp<smallest) {
				smallest=temp;
			}
			num= num/10;
		}
		System.out.println(largest);
		System.out.println(smallest);
	}

}
