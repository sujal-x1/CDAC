package day3_linkedlist_pointers;

public class Dynamic_Queue
{
    Node front,rear;
    void enqueue(int data)
    {
        Node n=new Node(data);
        if(front==null && rear==null)
            front=rear=n;
        else
        {
            rear.next=n;
            rear=n;
        }
    }
    void dequeue()
    {
        if(front==null && rear==null)
            System.out.println("Empty Queue");
        else
        {
            Node t=front;
            if(front==rear)
                front=rear=null;//manual reset
            else
                front=front.next;
            System.out.print("\nDequeued:"+t.data);
        }
    }
}
void printQueue()
{
    if(front==null && rear==null)
        System.out.println("Empty Queue");
    else
    {
        Node t=front;
        System.out.print("\nQueue has:");
        while(t!=null) {
            System.out.print(t.data + " - ");
            t = t.next;
        }
    }

}

public static void main(String[] args) {
    Dynamic_Queue queue=new Dynamic_Queue();
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    queue.printQueue();
    queue.dequeue();
    queue.printQueue();
}
}
