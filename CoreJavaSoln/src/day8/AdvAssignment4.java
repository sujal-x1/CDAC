package day8;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
public class AdvAssignment4 implements Runnable{
		ReentrantLock lock=new ReentrantLock();
		Condition c=lock.newCondition();
		public void run()
		{
			System.out.println();d
			lock.lock();
			perform();
			lock.unlock();
		}
		void perform()
		{
			for(int i=1;i<=10;i++)
			{
				if(i==6)
				{
					System.out.println("*************************");
					try {
						c.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(i);
				c.signalAll();
			}
			System.out.println("*************************");
		}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		AdvAssignment4 A = new AdvAssignment4();
		for(int i=0; i<2;i++) {
			exec.execute(A);
		}
		exec.shutdown();
	}
}