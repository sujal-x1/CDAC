package Logic_Building;

public class ABCpatternWithNums {

	public static void main(String[] args) {
		char i_char='a';
		
		for(int space=5,i=1;space>=1 && i<=5;space--,i++,i_char++)
		{
		    //space print
		    for(int s=1;s<=space;s++)
		        System.out.print(" ");
		    for(int j=1;j<=i;j++)//printer
		        System.out.print(i+""+i_char);
		    System.out.print("\n");//AFTER A LINE
		}
	}
}
