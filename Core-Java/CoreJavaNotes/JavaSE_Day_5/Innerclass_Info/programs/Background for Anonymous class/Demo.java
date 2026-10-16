interface MyInterface
{
	void disp();
}

class MyInterfaceImpl implements MyInterface
{
	public void disp()
	{
		System.out.println("in disp");
	}
}
class SomeClass
{
	static MyInterface getMyInterface()
	{
		return new MyInterfaceImpl();
	}	
}
public class Demo
{
	public static void main(String args[])
	{
		MyInterface ref1=SomeClass.getMyInterface();
		ref1.disp();
	}
}

