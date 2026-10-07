class base
{
	int i;
	base()
	{
		add(1);
	}
	private void add(int v)
	{
		i+=v;
	}
	void print()
	{
		System.out.println(i);
	}
}
class sub extends base
{
	sub()
	{
		add(2);
	}
	void add(int v)
	{
		i+=v*2;
	}
}
public class Special1
{
	static void disp(sub b)
	{
		b.add(8);
		b.print();
	}
	public  static void main(String args[]) 
	{
		disp(new sub());
	}
}