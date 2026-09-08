package day8;

public class Assignment3 implements Runnable{
		public synchronized void run() {
			for(int a=0;a<=5;a++) {
				System.out.println(Thread.currentThread().getName() +"Exec "+a);
			}
		}
	public static void main(String[] args) {
		Assignment3 a =new Assignment3 ();

		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(a);
		Thread t3 = new Thread(a);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
