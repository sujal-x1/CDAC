package Logic_Building;

public class PrimeAndCount {

    public static void main(String[] args) {

        int count = 0;

        for (int i = 2; i <= 50; i++) {
            int factors = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    factors++;
                }
            }

            if (factors == 2) {
                System.out.println(i);
                count++;
            }
        }

        System.out.println("Total prime numbers: " + count);
    }
}