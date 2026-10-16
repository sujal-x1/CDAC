package day4;


interface Game{
	public void play();
	
}

class cricket implements Game{
	public void play() {
		System.out.println("playing cric");
	}
}

class football implements Game{
	public void play() {
		System.out.println("playin football");
	}
}

class tennis implements Game{
		public void play() {
			System.out.println("playin tennis");
		}
	}


public class Demo {
	static void perform(Game ref) {
		ref.play();
	}
	public static void main(String[] args) {
		cricket c= new cricket();
		perform(c);

	}

}
