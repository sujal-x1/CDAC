package day3;
 abstract class Weapons{
	abstract void attack();
}
class sword extends Weapons{
	void attack() {
		System.out.println("sword was used");
	}
}
class gun extends Weapons{
	void attack() {
		System.out.println("gun was shot");
	}
	void reload() {
		System.out.println("im realoading...");
	}
}

class phantom extends Weapons {
	void spray() {
		System.out.println("spray and pray>>>");
	}

	void attack() {
		System.out.println("phantom was sprayed");
	}
}


public class Weaponstry {
	static void perform(Weapons ref) {
		ref.attack();
	}
	public static void main(String[] args) {
		sword s = new sword();
		perform(s);
	}

}
