package day8;

public class Assignment1 extends Thread{
	public void run() {
		for(char d='A';d<='J';d++) {
			System.out.println(d);
		}
	}

	public static void main(String[] args) {
		Assignment1 t1= new Assignment1();
		Assignment1 t2 = new Assignment1();
		t1.start();
		t2.start();
	}
}
