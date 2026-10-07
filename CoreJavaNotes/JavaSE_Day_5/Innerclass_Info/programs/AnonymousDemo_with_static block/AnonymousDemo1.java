class Base
{
	void disp()
	{
		System.out.println("inside base disp");
	}
}

class SomeClass
{
	public static Base getBase()
	{
		return new Base()
		{
			void disp()
			{
				System.out.println("inside child disp");
			}
		};
	}
}

public class AnonymousDemo1
{
	public static void main(String args[])
	{
		Base ref=SomeClass.getBase();
		ref.disp();
	}
}		