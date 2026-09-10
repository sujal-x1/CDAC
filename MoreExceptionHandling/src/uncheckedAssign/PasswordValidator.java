package uncheckedAssign;

public class PasswordValidator {
	void validatePassword(String password) {
		if(password.length()<8) {
			throw new WeakPasswordException("enter 8 digits");
		}
		else {
			System.out.println("password accepted");
		}
	}
}
