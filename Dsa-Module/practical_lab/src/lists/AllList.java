package lists;

public class AllList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//LinkedList ADT

/*
 * Node class represents one node of the linked list.
 * Each node stores data and a reference to the next node.
 */
class Node
{
    int data;      // Stores the value of the node
    Node next;     // Stores the address/reference of the next node

    // Constructor initializes a node with the given data
    Node(int data)
    {
        this.data = data;  // Assign the given value to data
        next = null;       // Initially, the node does not point to another node
    }
}


/*
 * Linear_Linked_List implements a singly linked list.
 * Each node points to the next node in the list.
 */
 class Linear_Linked_List
{
    Node root;  // Points to the first node of the linked list
                // If root == null, the list is empty


    // Inserts a new node at the beginning of the list
    void insertLeft(int e)
    {
        Node n = new Node(e);  // Create a new node containing e

        n.next = root;  // Make the new node point to the current first node
        root = n;       // Make the new node the first node
    }


    // Inserts a new node at the end of the list
    void insertRight(int e)
    {
        Node n = new Node(e);  // Create a new node containing e

        if(root == null)       // If the list is empty
        {
            root = n;          // The new node becomes the first node
        }
        else
        {
            Node t = root;     // Start traversing from the first node

            // Move until the last node is reached
            while(t.next != null)
                t = t.next;

            t.next = n;        // Link the last node to the new node
        }
    }


    // Deletes the first node of the list
    void deleteLeft()
    {
        if(root == null)  // Check whether the list is empty
            System.out.println("List is empty");
        else
            root = root.next; // Move root to the second node,
                              // removing the first node from the list
    }


    // Deletes the last node of the list
    void deleteRight()
    {
        if(root == null)  // Case 1: The list is empty
            System.out.println("List is empty");

        else if(root.next == null) // Case 2: Only one node exists
            root = null;           // Make the list empty

        else
        {
            Node t = root;  // Start from the first node 

            // Stop at the second-last node.
            // t.next.next becomes null when t.next is the last node.
            while(t.next.next != null)
                t = t.next;

            t.next = null;  // Disconnect the last node
        }
    }


    // Displays all nodes from the first node to the last node
    void printList()
    {
        Node t = root;  // Temporary pointer used for traversal

        // Visit each node until null is reached
        while(t != null)
        {
            System.out.print(t.data + " -> "); // Print current node's data
            t = t.next;                        // Move to the next node
        }

        System.out.println("null"); // Indicates the end of the list
    }


    // Searches for a given value in the linked list
    boolean searchList(int key)
    {
        Node t = root;  // Start searching from the first node

        while(t != null)  // Continue until the end of the list
        {
            if(t.data == key) // If the current node contains the key
                return true;  // Value found

            t = t.next;       // Move to the next node
        }

        return false; // Reached the end without finding the key
    }


    // Inserts a new node immediately after the first occurrence of key
    void insertAfter(int key, int e)
    {
        Node t = root;  // Start searching from the first node

        // Traverse until key is found or the end is reached
        while(t != null && t.data != key)
            t = t.next;

        if(t != null)  // If the key was found
        {
            Node n = new Node(e); // Create a new node containing e

            n.next = t.next; // Link the new node to the node after t
            t.next = n;      // Link t to the new node
        }
        // If key is not found, the list remains unchanged
    }


    // Deletes the first occurrence of the specified key
    void deleteElement(int key)
    {
        if(root == null)  // If the list is empty
            return;       // Nothing to delete

        if(root.data == key) // If the first node contains the key
        {
            root = root.next; // Remove the first node
            return;           // Stop because deletion is complete
        }

        Node t = root; // Start from the first node

        // Find the node just before the node containing key
        while(t.next != null && t.next.data != key)
            t = t.next;

        if(t.next != null) // If the key was found
            t.next = t.next.next; // Skip the matching node,
                                   // linking its previous node to its next node

        // If key is not found, the list remains unchanged
    }
}


// Circular Queue implementation using an array
 class Circular_Queue_Class
{
    int queue[];              // Array used to store queue elements
    int MaxSize;              // Maximum capacity of the queue
    int front, rear, count;   // Front index, rear index, and number of elements

    // Creates an empty circular queue of the specified size
    public void create_queue(int size)
    {
        MaxSize = size;       // Set the maximum capacity
        queue = new int[size];// Allocate memory for the array

        front = 0;            // Initially, front points to index 0
        rear = -1;             // -1 means no element has been inserted yet
        count = 0;             // Initially, the queue contains zero elements
    }

    // Inserts an element at the rear end of the queue
    void enqueue(int e)
    {
        if(isFull())          // Check whether the queue is full
        {
            System.out.println("Queue is full");
            return;
        }

        // Move rear forward circularly and insert the element
        rear = (rear + 1) % MaxSize;
        queue[rear] = e;

        count++;              // Increase the number of elements
    }

    // Returns true if the queue is full
    boolean isFull()
    {
        return count == MaxSize;
    }

    // Removes and returns the front element of the queue
    int dequeue()
    {
        if(isEmpty())         // Check whether the queue is empty
        {
            System.out.println("Queue is empty");
            return -1;        // Indicates that no element was removed
        }

        int e = queue[front]; // Store the front element before removing it

        // Move front forward circularly
        front = (front + 1) % MaxSize;

        count--;              // Decrease the number of elements

        return e;             // Return the removed element
    }

    // Returns true if the queue contains no elements
    boolean isEmpty()
    {
        return count == 0;
    }

    // Displays all elements from front to rear in queue order
    void printQueue()
    {
        if(isEmpty())         // Check whether the queue is empty
        {
            System.out.println("Queue is empty");
            return;
        }

        // Traverse the logical queue elements
        // Modulo allows the index to wrap around the array
        for(int i = 0; i < count; i++)
        {
            int index = (front + i) % MaxSize;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }
}
//Doubly linked list
class Dnode
{
   int data;
   Dnode left, right;

   Dnode(int data)
   {
       this.data = data;
       left = right = null;
   }
}

 class Doubly_Linked_List
{
   Dnode root;

   void insertLeft(int e)
   {
       Dnode n = new Dnode(e);

       if(root == null)
           root = n;
       else
       {
           n.right = root;
           root.left = n;
           root = n;
       }
   }

   void insertRight(int e)
   {
       Dnode n = new Dnode(e);

       if(root == null)
           root = n;
       else
       {
           Dnode t = root;

           while(t.right != null)
               t = t.right;

           t.right = n;
           n.left = t;
       }
   }

   void deleteLeft()
   {
       if(root == null)
           System.out.println("List is empty");
       else if(root.right == null)
           root = null;
       else
       {
           root = root.right;
           root.left = null;
       }
   }

   void deleteRight()
   {
       if(root == null)
           System.out.println("List is empty");
       else if(root.right == null)
           root = null;
       else
       {
           Dnode t = root;

           while(t.right != null)
               t = t.right;

           t.left.right = null;
       }
   }

   void printForward()
   {
       Dnode t = root;

       while(t != null)
       {
           System.out.print(t.data + " <-> ");
           t = t.right;
       }

       System.out.println("null");
   }

   void printReverse()
   {
       if(root == null)
           return;

       Dnode t = root;

       while(t.right != null)
           t = t.right;

       while(t != null)
       {
           System.out.print(t.data + " <-> ");
           t = t.left;
       }

       System.out.println("null");
   }
}

