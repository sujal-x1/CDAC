package core1;
import java.util.*;

/*
 * in the following code we get the proof that unless "sum"
 * i.e. terminal operation is called, nothing happens in 
 * stream i.e. elements are not processed (lazy)
 * 
 * if we enable "sum()" we get the output of "peek"  
 * otherwise not.
 * 
 * If no terminal operation is called → nothing executes 
 * → even peek() does not run
 */
public class ProofOfLazyDemo
{
	public static void main(String args[])
	{
		List<Integer>list=new ArrayList<>();
		list.add(10);
		list.add(23);
		list.add(5);
		list.add(56);
		
		int total=0;
		
		
		total=list.stream()
	    .filter(i -> i > 10)
	    .peek(i -> System.out.println("After filter: " + i))
	    .mapToInt(i -> i * 2)
	    .peek(i -> System.out.println("After map: " + i))
	    .sum();
	    
		
		/*
		list.stream()
	    .filter(i -> i > 10)
	    .peek(i -> System.out.println("After filter: " + i))
	    .mapToInt(i -> i * 2)
	    .peek(i -> System.out.println("After map: " + i));
		 */
		
		System.out.println();
		System.out.println("Total of numbers greater than 10 is\t"+total);
	}
}
