package practicallearning;
////Upcast and Downcast
public class Animal {
	void makesound() {
		System.out.println("Random animal sound");
	}
	
	static void display(Animal a) {
		if(a instanceof Dog ) {
			Dog d = (Dog)a;
			d.makesound();
		}
		if (a instanceof Cat) {
			Cat c = (Cat)a;
			c.makesound();
		}
	}
	
	public static void main(String[] args) {
		Animal arr[]= new Animal[3];
		arr[0]=new Dog();
		arr[1]=new Cat();
		arr[2]=new Animal();
		for (int i=0;i<arr.length;i++) {
			if(arr[i] instanceof Dog) {
				Dog d=(Dog)arr[i];
				d.makesound();
			}
			else if(arr[i] instanceof Cat) {
				Cat c=(Cat)arr[i];
				c.makesound();
			}
			else
			arr[i].makesound();
		}
	}
	}


class Dog extends Animal{
	void makesound() {
		System.out.println("bhaw bhaw");
	}
}

class Cat extends Animal{
	void makesound() {
		System.out.println("mew");
	}
}