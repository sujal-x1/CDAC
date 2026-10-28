package Logic_Building;

public class PalindromeOrNot {

    public static void main(String[] args) {

        int num = 123;
        int original = num;
        int rev = 0;

        while (num != 0) {
            int res = num % 10;
            rev = rev * 10 + res;
            num = num / 10;
        }

        if (original == rev) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}