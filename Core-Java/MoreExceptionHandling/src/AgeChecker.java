public class AgeChecker {

    public void verifyAge(int age) {

        AgeValidator validator = new AgeValidator();

        try {
            validator.checkAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
