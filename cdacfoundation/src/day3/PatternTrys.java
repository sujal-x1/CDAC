package day3;
import java.util.Scanner;
public class PatternTrys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc= new Scanner(System.in);
			int i,j,s;
			for(i=1;i<=3;i++) {
				for(s=3;s>i;s--) {
					System.out.print(" ");
				}
					for(j=4-i;j<=i;j++) {
						System.out.print(j);
					}
				
				System.out.println();
			}
	}
}
/*
   *           3
`   *         23
   *         123
  **
 ***
*/


