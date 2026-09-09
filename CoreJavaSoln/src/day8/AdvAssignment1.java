package day8;
import java.util.concurrent.*;
/*
 * create a multi-threaded application by
 *  using Thread pool.create 2 threads. each thread should 
 *  display characters from A to J. 
 *  [ make sure while one thread executes , other thread 
 *  should not interfere ]
 */
public class AdvAssignment1 implements Runnable{
	public synchronized void run() {
		perform();
	}
	 void perform() {
		for(char c='A';c<='J';c++) {
			System.out.println(c);
		}
		System.out.println("****************");
	}
	public static void main(String[] args) {
		ExecutorService exec= Executors.newFixedThreadPool(2);
		
		AdvAssignment1 A = new AdvAssignment1();
		for(int i=1;i<=2;i++) {
			exec.execute(A);
		}
		exec.shutdown();

	}
}
