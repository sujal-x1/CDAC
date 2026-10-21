
package day3_linkedlist_pointers;

public class Linear_Linked_List {
    Node root;

    //Only member, which we will be remembering
    // This is the member which is keeping the entire linked list alive.
    void insertLeft(int data) {
        Node n = new Node(data);//1 created node
        if (root == null)//Does not exist.
            root = n;//First ever entry becomes the root.
        else {
            n.next = root;//1 connect
            root = n;//2 move ahead
        }
    }

    void deleteLeft() {
        if (root == null)//Does not exist.
            System.out.println("LinkedList empty ");
        else {
            Node t = root;//1:created ref
            root = root.next;//2:move to next to right
            System.out.print("\nDeleted:" + t.data);//3:Response: who is deleted
        }
    }

    void insertRight(int data) {
        Node n = new Node(data);//1 created node
        if (root == null)//Does not exist.
            root = n;//First ever entry becomes the root.
        else {
            Node t = root;//1 created ref
            while (t.next != null)//2 go till last
                t = t.next;//move
            t.next = n;//3:attach
        }
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
            while (t != null)//2 go till last
            {
                System.out.print("|" + t.data + "|->");
                t = t.next;//move
            }
            System.out.print("null");
        }
    }

    boolean searchList(int key) {
        if (root == null)//Does not exist.
            System.out.print("\nEmpty List");
        else {
            Node t = root;//1 created ref
            while (t != null)//2 go till last
            {
                if (key == t.data)
                    return true;
                t = t.next;//move
            }

        }
        return false;
    }
    void insertAfter(int ref,int new_data)
    {
        if(root==null)
            System.out.println("Empty list");
        else
        {
            Node t=root;
            while(t!=null)
            {
                if(t.data==ref)//found
                {
                    //insert
                    Node n=new Node(new_data);//created n if ref is found
                    n.next=t.next;//1 ref to next of t
                    t.next=n;//ref to n new node
                    break;//stop
                }
                t=t.next;
            }
            if(t==null)
                System.out.print("\n"+ref+" not found");
        }
    }
    void deleteElement(int element)
    {
        if(root==null)
            System.out.println("Empty list");
        else
        {//create ref
            Node t=root;
            Node t2=root;
            while(t!=null)
            {
                if(t.data==element)//found
                {
                    //case ?
                    if(t==root)//case 1
                        root=root.next;
                    else if(t.next==null)//case 2
                        t2.next=null;
                    else//case 3
                        t2.next=t.next;
                    System.out.print("\nDeleted:" + t.data);//3:Response: who is delete
                    break;//stop
                }
                t2=t;//tail
                t=t.next;//move
            }
            if(t==null)
                System.out.print("\n"+element+" not found");
        }
    }


}

