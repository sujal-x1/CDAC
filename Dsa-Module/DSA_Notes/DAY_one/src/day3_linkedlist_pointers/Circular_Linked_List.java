package day3_linkedlist_pointers;

import java.util.Scanner;

//Circular linked list
public class Circular_Linked_List
{
    Node root,last;

    //Only member, which we will be remembering
    // This is the member which is keeping the entire linked list alive.
    void insertLeft(int data)
    {
        Node n = new Node(data);//1 created node
        if (root == null)//Does not exist.
            root =last= n;//`root` and `last` both refer to a single node `n`.
        else
        {
            n.next = root;//1 connect
            root = n;//2 move ahead
        }
        last.next=root;//3 in both cases last ->ref to root
    }


    void deleteLeft() {
        if (root == null)//Does not exist.
            System.out.println("LinkedList empty ");
        else {
            Node t = root;//1:created ref
            //single node
            if(root==last)
                root=last=null;//Manual reset
            else
            {
                root = root.next;//2:move to next to right
                last.next=root;//3
            }
            System.out.print("\nDeleted:" + t.data);//3:Response: who is deleted
        }
    }

    void insertRight(int data) {
        Node n = new Node(data);//1 created node
        if (root == null)//Does not exist.
            root =last= n;//First ever entry becomes the root.
        else {
            last.next=n;//1
            last=n;//2
        }
        last.next=root;//3
    }

    void deleteRight() {
        if (root == null)//Does not exist.
            System.out.println("LinkedList empty ");
        else {
            Node t = root;//1:created ref
            Node t2 = root;//1:created ref
            //t2 second last
            // t last
            while (t.next != null) {
                t2 = t;//wait at current
                t = t.next;//go ahead
            }
            if (t == root)//single node
                root = null;
            else
                t2.next = null;//break and null second last's ref as now it is last
            System.out.print("\nDeleted:" + t.data);//3:Response: who is deleted
        }
    }

    void printList() {
        if (root == null)//Does not exist.
            System.out.print("\nEmpty List");
        else {
            Node t = root;//1 created ref
            do
            {
                System.out.print("|" + t.data + "|->");
                t = t.next;//move
            }while (t != root);//2 go till last
            System.out.print("null");
        }
    }

    public static void main(String[] args) {
        //Menu driven
        Scanner sc = new Scanner(System.in);

        Circular_Linked_List list = new Circular_Linked_List();

        int choice, data, key, ref;

        do {
            System.out.println("\n===== LINEAR LINKED LIST MENU =====");
            System.out.println("1. Insert Left");
            System.out.println("2. Insert Right");
            System.out.println("3. Delete Left");
            System.out.println("4. Delete Right");
            System.out.println("5. Display List");
            System.out.println("6. Search Element");
            System.out.println("7. Insert After Reference Element");
            System.out.println("8. Delete Specific Element");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();

                    list.insertLeft(data);
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();

                    list.insertRight(data);
                    break;

                case 3:
                    list.deleteLeft();
                    break;

                case 4:
                    list.deleteRight();
                    break;

                case 5:
                    list.printList();
                    break;

//                case 6:
//                    System.out.print("Enter element to search: ");
//                    key = sc.nextInt();
//
//                    if (list.searchList(key))
//                        System.out.println("Element found.");
//                    else
//                        System.out.println("Element not found.");
//
//                    break;

                case 7:
                    System.out.print("Enter reference element: ");
                    ref = sc.nextInt();

                    System.out.print("Enter new data: ");
                    data = sc.nextInt();

                    list.insertLeft(ref, data);
                    break;

                case 8:
                    System.out.print("Enter element to delete: ");
                    data = sc.nextInt();

                    list.deleteLeft(data);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}



