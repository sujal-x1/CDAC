package day4;

public class Top1 {
	void display() {
		System.out.println("bad ans");
	}
	public static void main(String[] args) {
		Top1 t= new Bottom1 ();
		t.display();
		t= new Bottom2 ();
		t.display();
		t= new Bottom3 ();
		t.display();
	}

}
class Bottom1 extends Top1{
	void display() {
		System.out.println("disp 1");
	}
}
class Bottom2 extends Top1{
	void display() {
		System.out.println("disp 2");
	}
}
class Bottom3 extends Top1{
	void display() {
		System.out.println("disp 3");
	}
}