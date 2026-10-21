package day3_linkedlist_pointers;

public class Doubly_Linked_List
{
    Dnode root;

    void insertLeft(int data)
    {
        Dnode n = new Dnode(data);//1 created node
        if (root == null)//Does not exist.
            root = n;//First ever entry becomes the root.
        else
        {
            n.right = root;//1 connect
            root.left=n;//2
            root = n;//3 move ahead
        }
    }

    void deleteLeft() {
        if (root == null)//Does not exist.
            System.out.println("LinkedList empty ");
        else {
            Dnode t = root;//1:created ref
            root = root.right;//2:move to next to right
            if(root!=null)//iff not a single node
                root.left=null;
            System.out.print("\nDeleted:" + t.data);
            //3:Response: who is deleted
        }
    }

    void insertRight(int data) {
        Dnode n = new Dnode(data);//1 created node
        if (root == null)//Does not exist.
            root = n;//First ever entry becomes the root.
        else {
            Dnode t = root;//1 created ref
            while (t.right != null)//2 go till last
                t = t.right;//move
            t.right= n;//3:attach
            n.left=t;//4
        }
    }

    void deleteRight() {
        if (root == null)//Does not exist.
            System.out.println("LinkedList empty ");
        else {
            Dnode t = root;//1:created ref
            while (t.right != null)
                t = t.right;//go ahead

            if (t == root)//single node
                root = null;
            else
            {
                Dnode t2=t.left;//3
                t2.right=null;//4
            }
            System.out.print("\nDeleted:" + t.data);//3:Response: who is deleted
        }
    }

    void printList() {
        if (root == null)//Does not exist.
            System.out.print("\nEmpty List\n");
        else {
            Dnode t = root;//1 created ref
            System.out.print("null");
            while (t != null)//2 go till last
            {
                System.out.print("<-|" + t.data + "|->");
                t = t.right;//move
            }
            System.out.print("null");
        }
    }
    void printList_Reverse() {
        if (root == null)//Does not exist.
            System.out.print("\nEmpty List\n");
        else {
            Dnode t = root;//1 created ref
            while(t.right!=null)
                t=t.right;

            System.out.print("null");
            while (t != null)//2 go till last
            {
                System.out.print("<-|" + t.data + "|->");
                t = t.left;//move
            }
            System.out.print("null");
        }
    }

    Public static void main ()
{
//MENUDRIVEN
}
}
