package practicallearning;

import java.util.Scanner;

public class ArrayLogic {

   
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[5];
        for(int j=0;j<arr.length;j++) {
        	arr[j]=sc.nextInt();
        }
        int highest=0;
        int secondhigh=0;
        for (int i =0;i<arr.length;i++) {
        		if(arr[i]>highest) {
        			secondhigh=highest;
        			highest=arr[i];
        		}
        }
		System.out.println(secondhigh);

    }
}
