class Base
{
	public Base(int k)
	{
		System.out.println("inside base param constr\t"+k);
	}

	void disp()
	{
		System.out.println("inside base disp");
	}
}

class SomeClass
{
	public static Base getBase()
	{
		return new Base(100) // it's like super(100)
		{
			void disp()
			{
				System.out.println("inside child disp");
			}
		};
	}
}

public class AnonymousDemo2
{
	public static void main(String args[])
	{
		Base ref=SomeClass.getBase();
		ref.disp();
	}
}		