package day3_linkedlist_pointers;

public class Dynamic_Stack
{
    Node tos;

    void push(int data) {
        Node n = new Node(data);//1 created node
        if (tos == null)//Does not exist.
            tos = n;//First ever entry becomes the tos.
        else {
            n.next = tos;//1 connect
            tos = n;//2 move ahead
        }
    }

    void pop() {
        if (tos == null)//Does not exist.
            System.out.println("Stack empty ");
        else {
            Node t = tos;//1:created ref
            tos = tos.next;//2:move to next to right
            System.out.print("\nPoped:" + t.data);//3:Response: who is deleted
        }
    }
    void printStack() {
        if (tos == null)//Does not exist.
            System.out.print("\nEmpty Stack");
        else {
            Node t = tos;//1 created ref
            System.out.print("\nStack has");
            while (t != null)//2 go till last
            {
                System.out.print("\n|" + t.data + "|");
                System.out.print("\n----");
                t = t.next;//move
            }
        }
    }
    void peek()
    {
        if (tos == null)//Does not exist.
            System.out.println("Stack empty ");
        else
        {
            System.out.print("\n@Peek:" + tos.data);//3:Response: who is deleted
        }
    }


    public static void main(String[] args)
    {
        Dynamic_Stack stack=new Dynamic_Stack();
        //3 push
        stack.push(10);
        stack.push(20);
        stack.push(30);
        //1 print
        stack.printStack();
        //1 pop
        stack.pop();
        //1 peek
        stack.peek();
        //print
        stack.printStack();
    }

}

