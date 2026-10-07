/*

"Private methods cannot be overridden."

A child class can declare a method with exactly the same signature as the private method of the parent. It just does not override it. They are two completely independent methods.

Private methods are not overridden, so they do not participate in runtime polymorphism/dynamic method dispatch. A method call to a private method is resolved to the method belonging to the class where that private method is declared.
*/

class base
{
	private void disp()
	{
		System.out.println("base disp");
	}
}
class sub extends base
{
	void disp()  
	{
		System.out.println("sub disp");
	}
}
public class Demo7
{
	public static void main(String args[])
	{
		base ref=new sub();
		ref.disp(); // error  disp() has private access in base
	}
}











