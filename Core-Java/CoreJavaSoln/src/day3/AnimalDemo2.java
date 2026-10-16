package day3;

class Animal{
	void makesound() {
		
	}
}
class Tiger extends Animal{
	void makeSound()
	{
		System.out.println("roar");
	}
	void hunting()
	{
		System.out.println("hunt");
	}
}
class Dog extends Animal{
	void makesound() {
		System.out.println("Bark");
	}
}
class Cat extends Animal{
	void makesound() {
		System.out.println("meow");
	}
}
public class AnimalDemo2 {

	static void perform(Animal ref) {
		ref.makesound();
	
	if(ref instanceof Tiger) 
	{
		Tiger temp = (Tiger)ref;
		temp.hunting();
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		perform(new Tiger());
		perform(new Dog());
	}

}
