/*
 * Integer::sum 

 is a method reference

It is a shortcut for a lambda expression.

Equivalent lambda

(a, b) -> Integer.sum(a, b)
 */


import java.util.*;

public class ReduceDemo2
{
	public static void main(String args[])
	{
		List<Integer>list=new ArrayList<>();
		list.add(5);
		list.add(7);
		list.add(3);
		/*
		long sum = list.parallelStream()
		          .map(i -> i * i)
		          .reduce(0, Integer::sum);
		*/
		
		long sum = list.parallelStream()
		          .map(i -> i * i)
		          .reduce(0, (a, b) -> Integer.sum(a, b));
		
		System.out.println("Sum is\t"+sum);
	}
}
