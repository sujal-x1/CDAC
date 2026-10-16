import java.util.concurrent.atomic.AtomicInteger;

class Counter
{
    // AtomicInteger is a thread-safe class used when multiple threads
    // need to update an integer value safely without using synchronization.
    AtomicInteger count = new AtomicInteger();

    void increment()
    {
        // incrementAndGet() increases the value by 1 and returns the updated value.
        // Internally it uses CAS (Compare-And-Swap).

        // Conceptually it works like this:
        // 1. Read the current value.
        // 2. Calculate newValue = currentValue + 1.
        // 3. Try CAS: update the value only if it has not been changed by another thread.
        // 4. If another thread changed it, the operation retries until it succeeds.

        count.incrementAndGet();
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
        // Each thread increments the counter 1000 times
        for(int i=0;i<1000;i++)
        {
            c.increment();
        }
    }
}

public class Third_DemoWithAtomicInteger
{
    public static void main(String[] args) throws Exception
    {
        // Shared Counter object
        Counter c = new Counter();

        // Two threads share the same counter
        MyThread t1 = new MyThread(c);
        MyThread t2 = new MyThread(c);

        // Start both threads
        t1.start();
        t2.start();

        // main thread waits until both threads finish
        t1.join();
        t2.join();

        // Each thread increments 1000 times
        // Total expected value = 2000
        // AtomicInteger ensures that no updates are lost

        System.out.println(c.count);
    }
}