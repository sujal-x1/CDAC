package day_one_Stack_Examples;

public class Weapon{
	 void attack() {
		System.out.println("the weapon is being used");
	}
	
	 static void perform(Weapon ref) {
		 if(ref instanceof Gun) {
			 ((Gun) ref).reload();
			 ref.attack();
		 }
		 else
		 ref.attack();
	 }
	
	
	public static void main(String []args) {
		Weapon W = new Gun();
		Gun g = (Gun)W;
		perform(W);
		
	}
}


class Gun extends Weapon{
	void attack() {
		System.out.println("gun shot!");
	}
	void reload() {
		System.out.println("gun was reloaded");
	}
}

class Sword extends Weapon{
	void attack() {
		System.out.println("sword slash!");
	}
}

