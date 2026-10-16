package day4;

public class Fourwheeler extends Vehicle {
	public void start() {
		System.out.println("the four wheeler started");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v= new Fourwheeler();
		v.start();
	}

}
