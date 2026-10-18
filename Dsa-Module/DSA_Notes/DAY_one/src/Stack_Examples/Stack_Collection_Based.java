package Stack_Examples;

//Stack_Collection_Based.java
import java.util.Scanner;
import java.util.Stack; // In Collection

public class Stack_Collection_Based
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Create a Stack to store Integer values
        Stack<Integer> obj = new Stack<>();
        int choice = 0, e;
        do
        {
            System.out.print("\nStack Menu");
            System.out.print("\n-----------");
            System.out.print("\n1.Push");
            System.out.print("\n2.Pop");
            System.out.print("\n3.Peek");
            System.out.print("\n4.Print");
            System.out.print("\n0.Exit");
            System.out.print("\n:");

            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("\nEnter element to push:");
                    e = sc.nextInt();
                    // Insert the element into the stack
                    obj.push(e);

                    break;

                case 2:
                    // Check whether the stack is not empty
                    if (!obj.isEmpty())
                    {
                        // Remove and display the top element
                        System.out.print("\nElement popped:" +obj.pop());
                    }
                    else
                    {
                        System.out.print("\nStack Empty");
                    }
                    break;

                case 3:
                    // Check whether the stack is not empty
                    if (!obj.isEmpty())//obj.isEmpty()!=true
                    {
                        // Display the top element without removing it
                        System.out.print("\nElement @ Peek:" +obj.peek());
                    }
                    else
                    {
                        System.out.print("\nStack Empty");
                    }

                    break;

                case 4:
                    // Check whether the stack is not empty
                    if (!obj.isEmpty())
                    {
                        System.out.print("\nElements on Stack:\n");

                        // Traverse from the top element to the bottom
                        for (
                                int index =obj.size()-1 ;index >= 0;index--)
                        {
                            // Display the current stack element
                            System.out.print(obj.get(index)+"\n");

                        }
                    }
                    else
                    {
                        System.out.print("\nStack Empty");
                    }

                    break;

                case 0:
                    System.out.print(
                            "\nExiting code .. coded by amar.career"
                    );
                    break;

                default://Invalid input capturing
                    System.out.print("\nInvalid option selected.");
                    break;
            }

        } while (choice!=0);//Till the user is not giving zero, do not exit.

        sc.close();
    }
}

