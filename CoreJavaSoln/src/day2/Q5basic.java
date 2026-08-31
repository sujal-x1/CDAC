package day2;

public class Q5basic {
	String name;
	int age;
	 Q5basic(String name,int age){
		 this.name=name;
		 this.age=age;
		 System.out.println(name+" "+age);
	 }
	 Q5basic(int age){
		 this.age=age;
		 System.out.println(age);
	 }
	 Q5basic(){
		 System.out.println("no args here :(");
	 }
	 public static void main(String[]args) {
		 Q5basic q1= new Q5basic("2 args",22);
		 Q5basic q2= new Q5basic(2);
		 Q5basic q3= new Q5basic();
	 }
}
