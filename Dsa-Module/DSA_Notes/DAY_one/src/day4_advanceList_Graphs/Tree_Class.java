package day4_advanceList_Graphs;

public class Tree_Class {

    static Node root;

    // Insert a node into the BST
    static void insert(Node r, Node n) {
        if (root == null) {
            root = n;
        } else {
            if (n.data < r.data) {
                if (r.left == null)
                    r.left = n;
                else
                    insert(r.left, n);
            } else {
                if (r.right == null)
                    r.right = n;
                else
                    insert(r.right, n);
            }
        }
    }

    // Inorder: Left, Parent, Right (LPR)
    static void inorder(Node r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.data + "-");
            inorder(r.right);
        }
    }

    // Preorder: Parent, Left, Right (PLR)
    static void preorder(Node r) {
        if (r != null) {
            System.out.print(r.data + "-");
            preorder(r.left);
            preorder(r.right);
        }
    }

    // Postorder: Left, Right, Parent (LRP)
    static void postorder(Node r) {
        if (r != null) {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.data + "-");
        }
    }

    // Count leaf nodes
    static int countLeafNodes(Node r) {
        if (r == null)
            return 0;

        if (r.left == null && r.right == null)
            return 1;

        return countLeafNodes(r.left)
             + countLeafNodes(r.right);
    }
    
    static int countDepth(Node r) {
    		if(r==null) {
    			return 0;
    		}
    		int countleft = countDepth(r.left);
    		
    		int countright=countDepth(r.right);
    		if(countleft>countright) {
    			return countleft +1;
    		}
    		else return countright +1;
    }

    public static void main(String[] args) {

        insert(root, new Node(10));
        insert(root, new Node(5));
        insert(root, new Node(15));
        insert(root, new Node(12));
        insert(root, new Node(20));

        System.out.print("Inorder: ");
        inorder(root);

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);

        System.out.println(
            "\nLeaf nodes count: " + countLeafNodes(root)
        );
    }
}