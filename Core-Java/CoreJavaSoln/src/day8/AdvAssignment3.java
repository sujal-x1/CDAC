package day8;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
public class AdvAssignment3 implements Runnable{
	ReentrantLock lock = new ReentrantLock();
	public void run() {
		lock.lock();
		perform();
		lock.unlock();
	}
	void perform() {
		for(char c='A';c<='J';c++) {
			System.out.println(c);
		}
		System.out.println("*****************************");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		AdvAssignment3 A = new AdvAssignment3();
		for(int i=1;i<=2;i++) {
			exec.execute(A);
		}
		exec.shutdown();

	}

}
