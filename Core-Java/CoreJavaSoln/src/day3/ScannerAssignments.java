
package day3;

		/*import java.util.Scanner;

		public class ScannerAssignments {

		    public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);


		        // 1) ACCEPT MARKS AND DISPLAY CLASS

		        
		        System.out.print("Enter marks: ");
		        int marks = sc.nextInt();

		        if (marks > 75) {
		            System.out.println("Distinction");
		        }
		        else if (marks >= 60) {
		            System.out.println("First Class");
		        }
		        else if (marks >= 45) {
		            System.out.println("Second Class");
		        }
		        else if (marks >= 35) {
		            System.out.println("Pass Class");
		        }
		        else {
		            System.out.println("Fail");
		        }
		        */


		        // 2) CHECK WHETHER NUMBER IS DIVISIBLE BY 7
		        /*
		        System.out.print("Enter number: ");
		        int num = sc.nextInt();

		        if (num % 7 == 0) {
		            System.out.println("Divisible by 7");
		        }
		        else {
		            System.out.println("Not divisible by 7");
		        }
		        */


		        // 3) CHECK WHETHER CHARACTER IS VOWEL OR NOT

		        /*
		        System.out.print("Enter a character: ");
		        char ch = sc.next().charAt(0);

		        if (ch == 'a' || ch == 'e' || ch == 'i' ||
		            ch == 'o' || ch == 'u' ||
		            ch == 'A' || ch == 'E' || ch == 'I' ||
		            ch == 'O' || ch == 'U') {

		            System.out.println("Vowel");
		        }
		        else {
		            System.out.println("Not a vowel");
		        }
		        */


		        // 4) ACCEPT 2 NUMBERS AND OPERATOR

		        /*
		        System.out.print("Enter first number: ");
		        int num1 = sc.nextInt();

		        System.out.print("Enter operator (+, -, *, /, %): ");
		        char op = sc.next().charAt(0);

		        System.out.print("Enter second number: ");
		        int num2 = sc.nextInt();

		        switch (op) {

		            case '+':
		                System.out.println(num1 + num2);
		                break;

		            case '-':
		                System.out.println(num1 - num2);
		                break;

		            case '*':
		                System.out.println(num1 * num2);
		                break;

		            case '/':
		                System.out.println(num1 / num2);
		                break;

		            case '%':
		                System.out.println(num1 % num2);
		                break;

		            default:
		                System.out.println("Invalid operator");
		        }
		        */


		        // 5A) DISPLAY TABLE USING WHILE

		        /*
		        System.out.print("Enter number: ");
		        int num = sc.nextInt();

		        int i = 1;

		        while (i <= 10) {
		            System.out.println(num + " x " + i + " = " + (num * i));
		            i++;
		        }
		        */


		        // 5B) DISPLAY TABLE USING DO-WHILE

		        /*
		        System.out.print("Enter number: ");
		        int num = sc.nextInt();

		        int i = 1;

		        do {
		            System.out.println(num + " x " + i + " = " + (num * i));
		            i++;
		        } while (i <= 10);
		        */


		        // 5C) DISPLAY TABLE USING FOR

		        /*
		        System.out.print("Enter number: ");
		        int num = sc.nextInt();

		        for (int i = 1; i <= 10; i++) {
		            System.out.println(num + " x " + i + " = " + (num * i));
		        }
		        */


		        // 6) ACCEPT NUMBERS UNTIL USER ENTERS 0

		        /*
		        System.out.print("Enter number: ");
		        int num = sc.nextInt();

		        while (num != 0) {

		            System.out.println("You entered: " + num);

		            System.out.print("Enter number: ");
		            num = sc.nextInt();
		        }

		        System.out.println("You entered 0. Program ended.");
		        */


		        // 7) DISPLAY WHETHER NUMBER IS EVEN, ODD OR ZERO

		        /*
		        System.out.print("Enter number: ");
		        int num = sc.nextInt();

		        if (num == 0) {
		            System.out.println("Zero");
		        }
		        else if (num % 2 == 0) {
		            System.out.println("Even");
		        }
		        else {
		            System.out.println("Odd");
		        }


		        sc.close();
		    }
		}
	}

}*/



        // 8) CREATE INT ARRAY OF 5 ELEMENTS, ACCEPT 5 VALUES
        //    AND DISPLAY ALL NUMBERS

        /*
         
public class ScannerAssignments {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        // Accept 5 values
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number: ");
            arr[i] = sc.nextInt();
        }

        // Display all values
        System.out.println("Array elements:");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        */


        // 9) ACCEPT 5 VALUES IN ARRAY.
        //    ACCEPT ONE MORE NUMBER AND CHECK WHETHER
        //    THAT NUMBER EXISTS IN THE ARRAY OR NOT.

        /*
        int[] arr = new int[5];

        // Accept 5 values
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number: ");
            arr[i] = sc.nextInt();
        }

        // Accept number to search
        System.out.print("Enter number to search: ");
        int search = sc.nextInt();

        boolean found = false;

        // Search inside array
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == search) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Number is present in array");
        }
        else {
            System.out.println("Number is not present in array");
        }
        */


        // 10) ACCEPT 5 NUMBERS IN AN ARRAY AND DISPLAY THEIR SUM

        /*
        int[] arr = new int[5];

        int sum = 0;

        // Accept values and calculate sum
        for (int i = 0; i < arr.length; i++) {

            System.out.print("Enter number: ");
            arr[i] = sc.nextInt();

            sum = sum + arr[i];
        }

        System.out.println("Sum = " + sum);
        */


        // 11) ACCEPT 5 NUMBERS IN AN ARRAY
        //     AND SORT THEM IN ASCENDING ORDER

        /*
        int[] arr = new int[5];

        // Accept values
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number: ");
            arr[i] = sc.nextInt();
        }

        // Sorting using simple comparison
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {

                    // Swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Ascending order:");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        */


        // 12) ACCEPT 2 NUMBERS AND DISPLAY WHETHER
        //     A) FIRST NUMBER IS GREATER
        //     B) SECOND NUMBER IS GREATER
        //     C) BOTH ARE EQUAL

        /*
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        if (num1 > num2) {
            System.out.println("First number is greater");
        }
        else if (num2 > num1) {
            System.out.println("Second number is greater");
        }
        else {
            System.out.println("Both numbers are equal");
        }
        */


        // 13) ACCEPT 6 CHARACTERS IN AN ARRAY
        //     AND TOGGLE THEM IF THEY ARE ALPHABETS

        /*
        char[] arr = new char[6];

        // Accept 6 characters
        for (int i = 0; i < arr.length; i++) {

            System.out.print("Enter character: ");
            arr[i] = sc.next().charAt(0);
        }

        // Toggle alphabets
        for (int i = 0; i < arr.length; i++) {

            // Lowercase alphabet
            if (arr[i] >= 'a' && arr[i] <= 'z') {

                arr[i] = (char)(arr[i] - 32);
            }

            // Uppercase alphabet
            else if (arr[i] >= 'A' && arr[i] <= 'Z') {

                arr[i] = (char)(arr[i] + 32);
            }
        }

        // Display toggled characters
        System.out.println("Toggled characters:");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        */


        // 14) DISPLAY PRIME NUMBERS FROM 2 TO 20

        /*
        for (int num = 2; num <= 20; num++) {

            boolean prime = true;

            for (int i = 2; i < num; i++) {

                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                System.out.println(num);
            }
        }
        */


        // 15) ACCEPT A NUMBER AND DISPLAY WHETHER IT IS PRIME OR NOT

        /*
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        boolean prime = true;

        if (num < 2) {
            prime = false;
        }
        else {

            for (int i = 2; i < num; i++) {

                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }
        }

        if (prime) {
            System.out.println("Prime number");
        }
        else {
            System.out.println("Not a prime number");
        }
        */


        // 16) ACCEPT 3 DIGIT NUMBER AND CHECK WHETHER
        //     IT IS AN ARMSTRONG NUMBER OR NOT
        
        /*
        System.out.print("Enter a 3 digit number: ");
        int num = sc.nextInt();

        int original = num;
        int sum = 0;

        while (num > 0) {

            // Get last digit
            int digit = num % 10;

            // Add cube of digit
            sum = sum + (digit * digit * digit);

            // Remove last digit
            num = num / 10;
        }

        if (sum == original) {
            System.out.println("Armstrong number");
        }
        else {
            System.out.println("Not an Armstrong number");
        }


        sc.close();
    }
}*/