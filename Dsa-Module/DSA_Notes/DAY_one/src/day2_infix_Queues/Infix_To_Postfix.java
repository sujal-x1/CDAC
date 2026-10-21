package day2_infix_Queues;

//# Programming Problem: Infix to Postfix Conversion Using Stack

//
//## Problem Definition
//
//Write a Java program to convert a given infix expression into its equivalent postfix expression using the `Stack<Character>` collection class.
//
//The program should process the expression from left to right, handle operator precedence and parentheses, and print the resulting postfix expression.
//
//### Java Code — Fill in the Blanks
//
//```java

import java.util.Scanner;
import java.util.Stack;

public class Infix_To_Postfix {

static int precedence(char ch) {

	if (ch == '+' || ch == '-')
		return 1;

	if (ch == '*' || ch == '/' || ch == '%')
		return 2;

	return 0;
}

static String convert(String infix) {

	Stack<Character> stack = new Stack<>();

	String postfix = "";

for (int i = 0; i < infix.length(); i++)// till infix not over
{

	char ch = infix.charAt(i);

	if (ch == '(') {
		stack.push(ch);
	} 
	else if (ch == ')') {

		while (!stack.isEmpty() && stack.peek() != '(') {
			postfix = postfix + stack.pop();
		}

		if (!stack.isEmpty()) {
			stack.pop();// removing (
		}

	} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {

		while (!stack.isEmpty() && stack.peek() != '(' && precedence(ch) <= precedence(stack.peek())) {

			postfix = postfix + stack.pop();
		}

		stack.push(ch);

	} else {

		postfix = postfix + ch;

	}
}
//when done
	while (!stack.isEmpty()) {
		postfix = postfix + stack.pop();
	}

	return postfix;
}

public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	System.out.print("Enter infix expression: ");
	String infix = sc.next();

	String postfix = convert(infix);

	System.out.println("Postfix expression: " + postfix);

		sc.close();
	}
}

//## Sample Input
//
//```text
//A+B*C
//```

//## Sample Output
//
//```text
//Postfix expression: ABC*+
//```

//## Additional Test Case

//**Input**
//```text
//(A+B)*C
//```
//
//**Output**
//```text
//Postfix expression: AB+C*
//```
//
//### Instructions for Students
//
//- Complete every blank using the appropriate stack operation or condition.
//- Use `push()`, `pop()`, `peek()` and `isEmpty()` wherever required.
//- Do not change the `precedence()` method or the program structure.
//- The expression contains single-character operands and valid parentheses.
//
//
