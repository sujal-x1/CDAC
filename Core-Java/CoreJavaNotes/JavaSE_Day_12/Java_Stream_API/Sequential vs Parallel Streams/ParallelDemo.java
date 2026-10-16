/*

The difference between time taken by sequential streams and parallel streams here is small because the dataset and computation are moderate.
For larger datasets and heavier computations, parallel streams can give better performance, but it is not guaranteed in every case.

Because performance depends on:

	CPU cores

	Data size

	Complexity of work

	Overhead of thread management

conclusion:

Parallel Streams are useful when the amount of work is large enough that the time saved by using multiple threads is greater than the extra time required to divide and combine the work.

*/

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ParallelDemo
{
    public static void main(String... arg)
    {
        int max = 1000000;

        List<Integer> values = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            values.add(i);
        }

        long t0 = System.nanoTime();

        long sum = values.stream()
                .mapToLong(i -> i * i)   // simple logic: square of number
                .sum();

        long t1 = System.nanoTime();

        System.out.println("Sum using sequential stream\t" + sum);
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println("Sequential took: " + millis + " ms");

        t0 = System.nanoTime();

        sum = values.parallelStream()
                .mapToLong(i -> i * i)   // same logic
                .sum();

        t1 = System.nanoTime();

        System.out.println("Sum using parallel stream\t" + sum);
        millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println("Parallel took: " + millis + " ms");
    }
}