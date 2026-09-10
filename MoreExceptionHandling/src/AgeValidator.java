public class AgeValidator{
	public  void checkAge(int Age)throws InvalidAgeException {
		if(Age<18) {
			throw new InvalidAgeException("Age must be above 18");
		}
		else {
			System.out.println("Eligible for voting");
		}
		
	}
}
 