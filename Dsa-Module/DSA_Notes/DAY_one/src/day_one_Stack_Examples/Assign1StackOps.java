package day_one_Stack_Examples;
import java.util.Scanner;
import java.util.Stack;

public class Assign1StackOps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("size of array");
        int n = sc.nextInt();
        System.out.println("no of operations");
        int q = sc.nextInt();

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < q; i++) {
            String op = sc.next();

            switch (op) {
                case "PUSH1": {
                    int x = sc.nextInt();

                    if (stack1.size() + stack2.size() == n) {
                        System.out.println("Stack Overflow");
                    } else {
                        stack1.push(x);
                    }
                    break;
                }

                case "PUSH2": {
                    int x = sc.nextInt();

                    if (stack1.size() + stack2.size() == n) {
                        System.out.println("Stack Overflow");
                    } else {
                        stack2.push(x);
                    }
                    break;
                }

                case "POP1":
                    if (stack1.isEmpty()) {
                        System.out.println("Stack Underflow");
                    } else {
                        System.out.println(
                                "Popped from Stack1: " + stack1.pop()
                        );
                    }
                    break;

                case "POP2":
                    if (stack2.isEmpty()) {
                        System.out.println("Stack Underflow");
                    } else {
                        System.out.println(
                                "Popped from Stack2: " + stack2.pop()
                        );
                    }
                    break;

                case "DISPLAY1":
                    if (stack1.isEmpty()) {
                        System.out.println("Stack Underflow");
                    } else {
                        System.out.print("Stack1:");
                        for (int j = stack1.size() - 1; j >= 0; j--) {
                            System.out.print(" " + stack1.get(j));
                        }
                        System.out.println();
                    }
                    break;

                case "DISPLAY2":
                    if (stack2.isEmpty()) {
                        System.out.println("Stack Underflow");
                    } else {
                        System.out.print("Stack2:");
                        for (int j = stack2.size() - 1; j >= 0; j--) {
                            System.out.print(" " + stack2.get(j));
                        }
                        System.out.println();
                    }
                    break;
            }
        }

        sc.close();
    }
}
