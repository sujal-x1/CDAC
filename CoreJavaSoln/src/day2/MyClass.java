package day2;

public class MyClass {
	private int age;
	private int no;

	MyClass(){
		this.no=no;
		System.out.println(" 0arg");

	}
	MyClass(int no){
		this.no=no;
		System.out.println("1 arg");
	}
	MyClass(int no,int age){
		this.no=no;
		this.age=age;
		System.out.println("2 args");
	}
	
	
	public static void main(String[] args) {
		MyClass m1= new MyClass(1);
		MyClass m2= new MyClass(1,2);
		MyClass m3= new MyClass();
	}
}
