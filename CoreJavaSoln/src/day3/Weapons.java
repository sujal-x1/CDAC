package day3;

public class Weapons {
	void attack() {
		
	}
	static void  perform(Weapons ref) {
		if(ref instanceof Gun) {
			Gun g1=(Gun)ref;
			g1.reload();
		}
		ref.attack();
	}
	public static void main(String[] args) {
		perform(new Gun());
	}
}
class Gun extends Weapons{
	void attack() {
		System.out.println("The gun shot");
	}
	void reload() {
		System.out.println("the gun was reloaded");
	}
}

class Sword extends Weapons{
	void attack() {
		System.out.println("the sword slashed");
	}
}