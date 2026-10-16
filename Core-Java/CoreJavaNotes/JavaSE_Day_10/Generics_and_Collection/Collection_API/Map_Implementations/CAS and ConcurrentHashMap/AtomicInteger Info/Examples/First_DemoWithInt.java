/*
 * 
 * Initially, count = 5.
 *
 * Two threads (t1 and t2) share 
 * the same Counter object, and each thread
 * increments count 100 times.
 *
 * Ideally:
 *
 *     5 + 100 + 100 = 205
 *
 * However, count++ is NOT an atomic operation. 
 * Conceptually, it involves:
 *
 *     1. Read count
 *     2. Increment the value
 *     3. Write the value back
 *
 * Since both threads execute 
 * count++ concurrently, 
 * the following can happen:
 *
 *     T1: reads count = 10
 *     T2: reads count = 10
 *     T1: writes 11
 *     T2: writes 11
 *
 * Both threads have performed an increment, 
 * but the final value increased
 * only once. The increment performed by 
 * T1 is lost (or vice versa).
 *
 * This is called the LOST UPDATE problem.
 *
 * Therefore, the program may produce a value 
 * less than 205. The exact
 * output is not guaranteed because 
 * it depends on the timing/interleaving
 * of the two threads.
 *
 * Important:
 * The problem is NOT a drawback of int. 
 * An int is perfectly capable of
 * storing the required values. 
 * The problem is that count++ is not atomic
 * when multiple threads modify 
 * the same shared variable.
 *
 * To perform the increment atomically, 
 * we can use AtomicInteger:
 *
 *    AtomicInteger count = new AtomicInteger(5);
 *
 *    count.incrementAndGet();
 *
 * AtomicInteger provides atomic operations, 
 * so concurrent increments are not lost.
 */
 

package mypack;

class Counter
{
    int count = 5;

    void increment()
    {
        count++;
    }
}

class MyThread extends Thread
{
    Counter c;

    MyThread(Counter c)
    {
        this.c = c;
    }

    public void run()
    {
    	  for(int i=0;i<100;i++)
          {
              c.increment();
          }
    }
}

public class First_DemoWithInt
{
    public static void main(String[] args) throws Exception
    {
        Counter c = new Counter();

        MyThread t1 = new MyThread(c);
        MyThread t2 = new MyThread(c);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}