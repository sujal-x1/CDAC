package day_one_Stack_Examples;

class ArrayStack {
    int stack[], MaxSize, tos;

    void create_stack(int size) {
        MaxSize = size;
        stack = new int[size];
        tos = -1;
    }

    boolean isEmpty() { return tos == -1; }
    boolean isFull()  { return tos == MaxSize - 1; }

    void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++tos] = data;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[tos--];
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack empty");
            return -1;
        }
        return stack[tos];
    }

    void printStack() {
        for (int i = tos; i >= 0; i--)
            System.out.println(stack[i]);
    }
}
