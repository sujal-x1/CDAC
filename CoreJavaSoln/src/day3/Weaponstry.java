package day3;
   class Weapons{
	  void attack() {
	}
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
		if(ref instanceof gun) {
			gun ob=(gun)ref;
			ob.reload();
		}
		ref.attack();
	}
	public static void main(String[] args) {
		
		perform(new gun());
	}

}
