package practice;

public class stack {

	int tos;
	int maxsize;
	int arr[];
	public stack(int maxsize) {
		// TODO Auto-generated constructor stub
		this.maxsize=maxsize;
		arr = new int[maxsize];
		tos=-1;
	}
	
	boolean isFull()
	{
		return tos==maxsize-1;
	}
	
	boolean isEmpty()
	{
		return tos==-1;
	}
	
	void push(int x)
	{
		if(isFull())
		{
			System.out.println("Stack overflow");
			return;
		}
		arr[++tos] = x;
		System.out.println("Element pushed");
	}
	
	int pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack empty");
			return -1;
		}
		System.out.println("Deleted element "+arr[tos]);
		return arr[tos--];
	}
	
	int peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack empty");
			return -1;
		}
		return arr[tos];
	}
	
	void printStack()
	{
		if(isEmpty())
		{
			System.out.println("Stack underflow");
		}
		int i = tos;
		System.out.println("Stack: ");
		while(i>=0)
		{
			System.out.print(arr[i]+" ");
			i--;
		}
	}
	
	public static void main(String[] args) {
		stack s = new stack(5);
		s.push(2);
		s.push(6);
		System.out.println("popped element: "+s.pop());
		s.printStack();
	}
	
}