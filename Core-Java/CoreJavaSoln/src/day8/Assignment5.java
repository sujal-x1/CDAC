package day8;

public class Assignment5 implements Runnable{
	boolean ascending;
	Assignment5(boolean ascending){
		this.ascending=ascending;
	}
	public void run() {
		if(ascending) {
			for(int i= 1;i<=50;i++) {
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
		}
		else {
			for(int j=50;j>=1;j--) {
				System.out.println(Thread.currentThread().getName()+" "+j);
			}
		}
	}

	public static void main(String[] args) {
		Assignment5 a = new Assignment5(true);
		Assignment5 b = new Assignment5(false);
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		
		t1.start();
		t2.start();
		
	}

}
