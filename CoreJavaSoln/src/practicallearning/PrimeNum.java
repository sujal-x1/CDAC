package practicallearning;
//prime in array
public class PrimeNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,1,7,91,3,91,0,-1};
		int n;
		for(int i=0;i<arr.length;i++) {
			boolean flag = true;
			n=arr[i];
			if(n<2) {
				flag= false;
			}
			for(int j =2;j<n;j++) {
				if(n%j==0) {
					flag= false;
					break;

				}
			}
			if(flag==true) {
				System.out.println(n);
			}
			
		}
	}	
}

