import java.util.Locale;
import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int a;
        int b;
        int c;
        System.out.println("enter a:");
        a=sc.nextInt();
        sc.nextLine();
        System.out.println("enter b:");
        b=sc.nextInt();
        sc.nextLine();

        c=a%b;
        System.out.println(c);

    }
}
