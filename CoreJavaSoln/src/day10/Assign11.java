package day10;

import java.util.HashMap;
import java.util.Scanner;

public class Assign11 {

    public static void main(String[] args) {

        // Create HashMap
        HashMap<Integer, String> batsmen = new HashMap<>();

        // Store rank and batsman name
        batsmen.put(1, "Rohit Sharma");
        batsmen.put(2, "Virat Kohli");
        batsmen.put(3, "Babar Azam");
        batsmen.put(4, "Joe Root");
        batsmen.put(5, "Steve Smith");

        // Take rank from user
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rank between 1 and 5: ");
        int rank = sc.nextInt();

        // Check rank
        if (rank >= 1 && rank <= 5) {

            String name = batsmen.get(rank);

            System.out.println("Batsman at rank " + rank + " is: " + name);

        } else {

            System.out.println("Invalid rank. Please enter rank between 1 and 5.");

        }

        sc.close();
    }
}
