package day7;
import java.security.DrbgParameters.NextBytes;
import java.util.*;
public class PalinString {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str1=scanner.nextLine();
		
		int i,flag=0;
		
		char[]ch1=str1.toCharArray();
		int l=ch1.length;
		int h= l/2;
		
		for(i=0;i<h;i++) {
			if(ch1[i]!=ch1[l-1-i]) {
				flag=1;
				break;
			}
		}
		if(flag==1) System.out.print("not a palin");
		else System.out.println("a palin");
	}

}
