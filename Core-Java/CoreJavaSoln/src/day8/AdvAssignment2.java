package day8;
import java.util.concurrent.*;
public class AdvAssignment2 implements Runnable {
	public synchronized void run() {
		perform();
	}
	public void perform() {
		for(int i=1;i<=10;i++) {
			if(i==6) {
				try {
					wait();
				}
				catch(InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			System.out.println(i);
			notifyAll();
		}
	}
	public static void main(String[] args) {
		ExecutorService exec= Executors.newFixedThreadPool(2);
		
		AdvAssignment2 A = new AdvAssignment2();
		for(int j=1;j<=2;j++) {
			exec.execute(A);
		}
		exec.shutdown();
	}

}
	

