package day2;
public class Shape{
	private int width=33;
	private int height=99;
	
	 int getw(){
		return width;
	}
	int geth() {
		return height;
	}
}
class High{
	public static void main(String [] args) {
		Shape s1= new Shape();
		int width=s1.getw();
		int height = s1.geth();
		System.out.println(width);
		System.out.println(height);
	}
}