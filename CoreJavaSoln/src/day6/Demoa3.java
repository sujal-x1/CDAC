package day6;

import java.util.Scanner;

class MyException extends Exception {

    MyException(String message) {
        super(message);
    }
}

public class Demoa3 {

    public void show1() {
        try {
            show2();
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void show2() throws MyException {
        show3();
    }

    public void show3() throws MyException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int num = sc.nextInt();

        if (num > 10) {
            throw new MyException("The number is greater than 10");
        }
        else {
            System.out.println("Number: " + num);
        }
    }

    public static void main(String[] args) {

        Demoa3 d = new Demoa3();

        d.show1();
    }
}
