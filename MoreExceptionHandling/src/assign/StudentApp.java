package assign;
import java.util.Scanner;
public class StudentApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Student s = new Student();
		try {
			s.setMarks(0);
		} catch (InvalidMarksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
