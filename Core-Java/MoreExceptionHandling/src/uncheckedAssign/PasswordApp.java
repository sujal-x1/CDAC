package uncheckedAssign;
import java.util.Scanner;
public class PasswordApp {
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	String pass=sc.nextLine();
	PasswordValidator p = new PasswordValidator();
	try {
		p.validatePassword(pass);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
