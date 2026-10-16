package day3;

class first{
	int age;
	void function() {
		System.out.println("this is mem function");
	}
	
	 first  ( int age) {
		this.age=age;
	}
}

class second{
	static int sec=22;
	public static void main(String[] args) {
		first f1= new first(29);
		f1.function();
		System.out.println(sec);
	}
}


public class Inheritance_assignments {

	

}
