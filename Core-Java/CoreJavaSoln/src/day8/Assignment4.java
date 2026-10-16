package day8;
/*
 * 4)create 2 threads. Write a program which displays number 1 to 10 using class lock. 
[hint:- use "implements Runnable" and synchronized block]

 */
public class Assignment4 implements Runnable {
	public  void run() {
	synchronized(Assignment4.class){
		for(int a=1;a<=10;a++) {
			System.out.println(Thread.currentThread().getName()+" "+a);
		}
		}
	}
	public static void main(String[] args) {
		Assignment4 a1 = new Assignment4();
		Assignment4 a2 = new Assignment4();

		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a2);

		t1.start();
		t2.start();
	}

}
