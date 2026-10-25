package trees;

public class BinarySearchTree {
	static Node insert(Node r,Node n) {
		if(r==null) {
			return  n;		
		};
		if(r.data<n.data) {
			r.left=insert(r.left,n);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}