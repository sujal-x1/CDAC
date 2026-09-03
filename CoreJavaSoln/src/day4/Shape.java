package day4;

public abstract class Shape {
	  abstract  void draw();
		
	
	public static void main(String[] args) {
		Shape shape []= new Shape[3];
		Triangle t1= new Triangle();
		Polygon p1= new Polygon();
		Circle c1 = new Circle();
		shape[0]=t1;
		shape[1]=p1;
		shape[2]=c1;
		shape[0].draw();
		shape[1].draw();
		shape[2].draw();
	}

}
class Triangle extends  Shape{
	void draw() {
		System.out.println("a triangle was drawn");
	}
}
class Polygon extends  Shape{
	void draw() {
		System.out.println("a Polygon was drawn");
	}
}
class Circle extends  Shape{
	void draw() {
		System.out.println("a Circle was drawn");
	}
}

