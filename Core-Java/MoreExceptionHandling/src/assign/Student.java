package assign;

public class Student {
	void setMarks(int marks) throws InvalidMarksException {
		if(marks>=0 && marks <=100) {
			System.out.println(marks);
		}
		else {
			throw new InvalidMarksException("Marks are invalid");
		}
	}
}
