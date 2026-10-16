/*package day2;

class A{
	static{
		System.out.println("Initailizer of A");
	}
	static int varA=10;
	int vara=20;
	
	static void varA() {
		System.out.println("static meth of A");
	}
	 void vara() {
		System.out.println("nonstatic meth of a");
	}
}
class B{
	static int varB=30;
	int varb=40;
	static{
		System.out.println("Initailizer of B");
	}
	static void varB() {
		System.out.println("static meth of B");
	}
	 void varb() {
		System.out.println("nonstatic meth of b");
	 }
}
class C{
	static int varC=50;
	int varc=60;
	static{
		System.out.println("Initailizer of C");
	}
	static void varC() {
		System.out.println("static meth of C");
	}
	 void varc() {
		System.out.println("nonstatic meth of c");
	 }
}
public class DemoOb {
	
	public static void main(String[] args) {
		System.out.println(A.varA);
		A a1 = new A();
		System.out.println(a1.vara);
		A.varA();
		a1.vara();
		System.out.println("###class B####");
		
		
		System.out.println(B.varB);
		B b1 = new B();
		System.out.println(b1.varb);
		B.varB();
		b1.varb();
		
		System.out.println(C.varC);
		C c1 = new C();
		System.out.println(c1.varc);
		C.varC();
		c1.varc();

	}

}
*/