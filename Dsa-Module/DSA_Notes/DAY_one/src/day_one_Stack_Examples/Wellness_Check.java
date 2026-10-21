package day_one_Stack_Examples;//wellness of paranthesis
import java.util.Scanner;
import java.util.Stack;

public class Wellness_Check
{
	static boolean check(String pattern)
	{
		Stack<Character> stack = new Stack<>();

		// STUDENT: Write logic to check
		for(char c:pattern.toCharArray())
		{
			if(c=='{')
				stack.push(c);
			else if(c=='}')
			{
				if(stack.isEmpty())
					return false;
				else
				{
					stack.pop();
				}
			}
		}

		// whether the pattern contains balanced { }
		return stack.isEmpty();//if empty:true if not :false
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		String pattern;

		System.out.println("Enter pattern to check:");
		pattern = sc.next();

		System.out.print(
				"\nPattern is balanced:" + check(pattern));
	}
}

