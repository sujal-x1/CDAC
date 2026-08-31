package day2;
import java.util.Scanner;
//Q1.	Accept 10 number user and do sum of it.(do not use array)
/*
public class day2qna {
	public static void main(String[] args) {
		int i,num,res=0;
		System.out.println("enter 10 no:");
		Scanner sc= new Scanner(System.in);
		for(i=1;i<=10;i++) {
			num=sc.nextInt();
			res+=num;
		}
		System.out.println(res);
		
	}
}
*/
//Q2.Accept a number from user and find a factorial of a number
/*
public class day2qna {
	public static void main(String[] args) {
		int i,num=0,res=0;
		System.out.println("enter no:");
		Scanner sc= new Scanner(System.in);
		num=sc.nextInt();
		for(i=1;i<=num;i++) {
			if(num%i==0) {
				System.out.println(i);
			}
		}
		
	}
}

*//*
//Q3.	Accept 10 number from user count how many are  positive ,negative , zero
public class day2qna {
	public static void main(String[] args) {
		int i,num;
		int p=0,n=0,z=0;
		System.out.println("enter 10 no:");
		Scanner sc= new Scanner(System.in);
		for(i=1;i<=10;i++) {
			num=sc.nextInt();
			if(num>0) {
				p+=1;
			}
			else if (num<0) {
				n+=1;
			}
			else {
				z+=1;
			}
			
		}
		System.out.println("positive="+p+"negative="+n+"zero"+z);
	}
}
*/


//Q4.	Accept   a number from user  and do sum of digit
/*
public class day2qna {
	public static void main(String[] args) {
		int num1,temp=0;
		System.out.println("enter a number :");
		Scanner sc= new Scanner(System.in);
		num1=sc.nextInt();
		while (num1%10!=0) {
		temp+=num1%10;
		num1=num1/10;
	}
		System.out.println(temp);
	}
}

/*
//Q5.	Accept a number from user and reverse it.
public class day2qna {
	public static void main(String[] args) {
		int num1 ;
		System.out.println("enter 2 nums:");
		Scanner sc= new Scanner(System.in);
		num1=sc.nextInt();
		
		reversal(num1);
	}
	public static void reversal(int a ) {
		int reverse =0;
		while (a!=0) {
		int digit= a%10;
		reverse=reverse*10+digit;
		a=a/10;
	}
		System.out.print(reverse);

	}

}
*/
/*
public class day2qna {
	public static void main(String[] args) {
		int num1 ;
		System.out.println("enter num:");
		Scanner sc= new Scanner(System.in);
		num1=sc.nextInt();
		
		int reverse=reversal(num1);
		if (reverse== num1) {
			System.out.println("is a palin");
		}
		else System.out.println("not a palin");
	}
	
	public static int reversal(int num ) {
		int reverse =0;
		while (num!=0) {
		int digit= num%10;
		reverse=reverse*10+digit;
		num=num/10;
	}
		return reverse;
		
	}
}
*/
//Q7.	Accept a number from user and print a table of that number
/*
import java.util.Scanner;

public class day2qna {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int num = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }

        sc.close();
    }
}
*/
//Q8. special number or nah
/*
import java.util.Scanner;
public class day2qna {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int num = sc.nextInt();

        int original = num;
        int sum = 0;

        while(num!=0) {
        	int digits=num%10;
        	int fact=1;
        	for(int i=1;i<=digits;i++) {
        		fact=fact*i;
        	}
        	sum=sum+fact;
        	num=num/10;
        }
        
        if (sum == original) {
            System.out.println("Special Number");
        } else {
            System.out.println("Not a Special Number");
        }

        sc.close();
    }
}
*/
//Q9.	Accept a 3 digit number from user and check if it is Armstrong number or not
import java.util.Scanner;
public class day2qna {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int num = sc.nextInt();
        int original=num;
        int sum=0;
        
        while(num!=0) {
        	int digits=num%10;
        	int a=1;
        	a=digits*digits*digits;
        	sum=sum+a;
        	num=num/10;
        }
        
        if (sum == original) {
            System.out.println("Armstrong number");
        } else {
            System.out.println("Not an Armstrong number");
        }

        
    }
}