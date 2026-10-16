class base
{
	static void disp()
	{
		System.out.println("base disp");
	}
}
class sub extends base
{
	static void disp()
	{
		System.out.println("sub disp");
	}
}
public class Demo1
{
	public static void main(String args[])
	{
		sub s=new sub();
		s.disp();     // sub disp
		base ref=new sub();
		ref.disp();

/*
   What compiler resolves:

   s.disp();     -> sub.disp();
   ref.disp();   -> base.disp();

   Static methods are resolved using the reference type,
   not the actual object type.
*/

	}
}




