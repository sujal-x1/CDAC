package day3;
import java.util.Scanner;
public class Rev {

	public static void main(String[] args) {

//10) accept 5 numbers in an array and display their sum.
		int []arr= {5,6,9,8,1};
		int[]sort=new int[5];
		int temp;
		for (int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1;j++)
			if(arr[j]>arr[j+1]) {
				temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
//		for (int i = arr.length; i >=0; i--) {
//			for(int j=0;j<arr.length;j++)
//			arr[i]=sort[j];
//		}
		for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }//		
	}
}
