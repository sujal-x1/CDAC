package day2;

public class Student {
	int id;
	String name;
	double marks;
	static String college_name="Terna";
	
	
	Student(int id,String name,double marks){
		this.id=id;
		this.name=name;
		this.marks=marks;
		}
	
	
	static  void changecollegename(String newcollegename) {
		college_name=newcollegename;
	}
	
	void displayDetails() {
		System.out.println("id"+"="+id);
		System.out.println("name"+"="+name);
		System.out.println("marks"+"="+marks);
		System.out.println("college name"+"="+college_name);
	}

	
	public static void main(String[] args) {
		//creating students
		Student s1=new Student(1,"sujal",25);
		Student s2=new Student(2,"shreyas",24);
		Student s3=new Student(3,"kanhaiya",23);
		Student s4=new Student(4,"haddi",22);
		Student s5=new Student(5,"pratik",21);
		
		//display students
		s1.displayDetails();
		s2.displayDetails();
		s3.displayDetails();
		s4.displayDetails();
		s5.displayDetails();		
	}
}


