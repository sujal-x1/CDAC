package day8;

public class Assignment2 implements Runnable {
	public void run() {
		for(char j='A';j<='J';j++) {
			System.out.println(j);
		}
	}
	public static void main(String[] args) {
		Assignment2 t1= new Assignment2();
		
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t1);
		
		thread1.start();
		thread2.start();
	}

}
