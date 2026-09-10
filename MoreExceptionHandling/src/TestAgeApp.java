import java.util.Scanner;
public class TestAgeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int age=sc.nextInt();
		AgeChecker c= new AgeChecker();
		c.verifyAge(age);
	}

}
