package day2;

public class Emp{
	private static int cnt;
	private String name;
	private int age;
	
	Emp(String name,int age){
		this.name=name;
		this.age=age;
		cnt++;
	}
	
	static void getcnt() {
		System.out.println(cnt);
	}
}
class N{
	public static void main(String[] args) {
		Emp e1 = new Emp("aaron",22);
		Emp.getcnt();
		Emp e2 = new Emp("baron",23);
		Emp.getcnt();
		Emp e3 = new Emp("charon",24);
		Emp.getcnt();	
	}
}