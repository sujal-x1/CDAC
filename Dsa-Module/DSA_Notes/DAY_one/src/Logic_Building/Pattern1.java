package Logic_Building;

public class Pattern1
{
    public static void main(String[] args) {
        for(int i=7;i>=1;i-=2)//controller
        {
            for(int j=1;j<=i;j++)//printer
            {
                System.out.print("X");
            }
            System.out.print("\n");
        }
    }
}
