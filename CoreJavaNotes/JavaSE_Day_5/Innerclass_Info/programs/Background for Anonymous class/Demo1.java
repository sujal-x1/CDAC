interface MyInterface
{
	void disp();
}

class SomeClass
{
	static MyInterface getMyInterface()
	{
		class MyInterfaceImpl implements MyInterface
		{
			public void disp()
			{
				System.out.println("in disp of implementation");
			}
		}
		return new MyInterfaceImpl();
	}	
}
public class Demo1
{
	public static void main(String args[])
	{
		MyInterface ref1=SomeClass.getMyInterface();
		ref1.disp();
	}
}

