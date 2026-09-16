package practicallearning;

import java.util.Scanner;

public class ArrayLogic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[5];
        for(int j=0;j<arr.length;j++) {
        	arr[j]=sc.nextInt();
        }

        for (int i =0;i<arr.length;i++) {
        		for(int k =i+1;k<arr.length;k++) {
        			if(arr[i]==arr[k]) {
        				System.out.println(arr[i]);
        			}
        		}
        		}
        }
    }
