package day1;


/*
 Q1.	Swap 2 variable without using 3rd variable .(three answer)
Q2.	Accept three no and find out the highest  no.
Q3.	Accept a year from user check if it is leap year or not
Q4.	Accept a character from user and reverse the case eg. Input   aout put   A
Q5.	Accept a character from user and check if it is vowel or not
Q6.	Accept a marks from user and print it’s grade
a.	Mks>=75  grade A
b.	Mks>=55 grade B
c.	Mks>=35 grade c
d.	Else fail
Q7.	Accept a number from user - if it is divisible by 3 print “three” , if it is divisible by 7 print “seven” and if it is divisible by both(3,7) print “three -seven”
Q8.	An electric power distribution co. charges its domestic consumers as follows
follows: consumption units
a.	0-200			            0.50 perunit
b.	201-400			100+0.65 pu.excess of 200
c.	401-600			230+0.80pu.excess of 400
d.	601 and above	390+1.00pu in excess of 600
Q9.	Accept a number from user check if it is odd or even number
Q10.	Enter sex m/f  and salary- if m-salary>8000 tax is 5% of salary else 2%if f-salary>5000 tax is 3% else tax is 1% find a net salary=salary-tax
Q11.	Accept 3 digit number from user and do the sum of its digit .(do not use any loop)
Q12.	Accept years of investment rate of interest and principal amount of investment find simple interest
Q13.	Problem: Given the length of four sides determine whether they can be used to create a polygon and determine if that polygon is a square. A polygon can be created if no single side is greater than the sum of the other three sides. Display a ONE when the status (polygon or square) is confirmed and ZERO when the status cannot be confirmed.

Example Execution #1:
Enter the length of the four sides: 4 3 2 9
Length of sides: 4, 3, 2, 9
Polygon status: 1
Square status: 0

Example Execution #2:
Enter the length of the four sides: 5 5 5 5
Length of sides: 5, 5, 5, 5
Polygon status: 1
Square status: 1

Example Execution #3:
Enter the length of the four sides: 84 25 20 15
Length of sides: 84, 25, 20, 15
Polygon status: 0
Square status: 0

Q14 Assignment 1 ( Determining the Type of a Triangle)
Problem Statement: 
Consider a triangle with three sides measuring a, b, and c units. A triangle is a right-angled triangle if
a 2 + b2 = c2
Allow a tolerance of 0.000001 in the comparison in the above case i.e
a2 + b2 = c2 +/- 0.000001

A triangle is an isosceles triangle if any two of its sides are equal.
A triangle is an equilateral triangle if all the three sides are equal.

Three values can be the dimensions of a triangle if and only if the sum of every pair of values isgreater than the third value. Otherwise, it is an invalid triangle.

Write a program that reads three real numbers and finds out whether they can be the sides of thetriangle and if they do, prints what type of triangle it is. Even though all equilateral triangles are isosceles, your program should classify an equilateral triangle to be an equilateral only. Similarly
isosceles right-angled triangles should be classified as right-angled and not isosceles. A valid trianglewhich does not belong to any of the special types belongs to the notspecial category.
The three sides will be given as real numbers separated by blanks. The program should print the typeof the triangle in words using lower case letters followed by eoln without any blanks.
Thus the possible answers are
invalid
right-angled
isosceles
equilateral
notspecial

 */

/////////////////////////////////Q1

/*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
    int a ;
    int b;
    Scanner sc= new Scanner(System.in);
        System.out.println("enter num a: ");
        a=sc.nextInt();
        System.out.println("enter num b: ");
        b=sc.nextInt();

        a=a+b;//2+3=5
        b=a-b;//5-3=2
        a=a-b;//5-2=3

        System.out.println("a="+a);
        System.out.println("b="+b);

    }
}
*/
/*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        int a ;
        int b;
        Scanner sc= new Scanner(System.in);
        System.out.println("enter num a: ");
        a=sc.nextInt();
        System.out.println("enter num b: ");
        b=sc.nextInt();

        a=a*b;
        b=a/b;
        a=a/b;

        System.out.println("a="+a);
        System.out.println("b="+b);

    }
}*/
/*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        int a ;
        int b;
        Scanner sc= new Scanner(System.in);
        System.out.println("enter num a: ");
        a=sc.nextInt();
        System.out.println("enter num b: ");
        b=sc.nextInt();

        a=a^b;//010-011-->001
        b=a^b;//001-011-->010
        a=a^b;//001-010--->011

        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}*/
///Q2.	Accept three no and find out the highest  no.

/*
public class day1Qna {
	public static void main(String[] args) {
		int a,b,c;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter 3 no");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		if(a>b) {
			if(a>c) {
				System.out.println("a is greatest");
			}
			else {
				System.out.println("c is greatest");
			}
		}
		else if(b>a) {
			if(b>c) {
				System.out.println("b is greatest");
			}
			else {
				System.out.println("c is greatest");
			}
		}
	}
}
*/

//////////////////Q3Accept a year from user check if it is leap year or not
/*
public class day1Qna {
	public static void main(String[] args) {
		int year;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a year");
		year=sc.nextInt();
		if(year%400==0) {
			System.out.println("is a leap year");
		}
		else if (year%4==0 && year%100!=0) {
			System.out.println("is a leap year");
		}
		else {
			System.out.println("not a leap year");
		}
	}
}
*/
///Q4.	Accept a character from user and reverse the case eg. Input a output A
/*
 
public class day1Qna {
	public static void main(String[] args) {

		char a,b;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a char");
		a=sc.next().charAt(0);
		if (a>='a'&&a<='z') {
			b=(char)(a-32);
		}
		else if (a>='A'&&a<='Z') {
			b=(char)(a+32);
		}
		else {
			b=a;
		}
		System.out.println(b);
	}
}
*/
//Q5.	Accept a character from user and check if it is vowel or not
/*
public class day1Qna {
	public static void main(String[] args) {

		char a;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a char");
		a=sc.next().charAt(0);
		if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'
                || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
			System.out.println("is a vowel");
		}
		else {
			System.out.println("not a vowel");
		}
	}
}
*/
///Q6.	Accept a marks from user and print it’s grade
//a.	Mks>=75  grade A
//b.	Mks>=55 grade B
//c.	Mks>=35 grade c
/*
public class day1Qna {
	public static void main(String[] args) {

		int a;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a char");
		a=sc.nextInt();
		if(a>=75) {
			System.out.println("grade A");
		}
		else if (a>=55) {
			System.out.println("grade B");
			
		}
		else if(a>=35){
			System.out.println("grade C");
		}
		else{
			System.out.println("fail");
		}
	}
}
*/
///Q7.	Accept a number from user - if it is divisible by 3 print “three” , if it is divisible by 7 print “seven” and if it is divisible by both(3,7) print “three -seven”
/*
public class day1Qna {
	public static void main(String[] args) {

		int num;
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        num = sc.nextInt();

        if (num % 3 == 0 && num % 7 == 0) {
            System.out.println("three-seven");
        }
        else if (num % 3 == 0) {
            System.out.println("three");
        }
        else if (num % 7 == 0) {
            System.out.println("seven");
        }
        else {
            System.out.println("not divisible by 3 or 7");
        }
    }
}
*/
/*
 *Q8.	An electric power distribution co. charges its domestic consumers as follows
follows: consumption units
a.	0-200			            0.50 perunit
b.	201-400			100+0.65 pu.excess of 200
c.	401-600			230+0.80pu.excess of 400
d.	601 and above	390+1.00pu in excess of 600
 */
/*
public class day1Qna {
	public static void main(String[] args) {

		int units;
		double bill;
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter units");
        units = sc.nextInt();
        if(units<=200) {
        	bill=units*0.50;
        }
        else if(units<=400) {
        	bill=100+(units-200)*0.65;
        }
        else if (units <= 600) {
            bill = 230 + (units - 400) * 0.80;
        }
        else {
            bill = 390 + (units - 600) * 1.00;
        }

        System.out.println("Electricity bill = " + bill);
    
	}
}
*/
//Q9.	Accept a number from user check if it is odd or even number
/*
 import java.util.Scanner;

public class day1Qna {
    public static void main(String[] args) {

        int num;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("Even number");
        }
        else {
            System.out.println("Odd number");
        }
    }
}
 */
//Q10.	Enter sex m/f  and salary- if m-salary>8000 tax is 5% of salary 
//      else 2%if f-salary>5000 tax is 3% else tax is 1% find a net salary=salary-tax
/*
public class day1Qna {
    public static void main(String[] args) {

        double salary ;
        double tax;
        boolean isMale;
        String gender;

        Scanner sc = new Scanner(System.in);
        System.out.println("enter your gender");
        gender=sc.next();
        isMale=gender.equalsIgnoreCase("male");

        System.out.println("Enter a salary:");
        salary = sc.nextInt();
        
        if(isMale && salary>=8000) {
        		tax=salary*0.05;
        }
        else if(isMale) {
        		tax=salary*0.02;
		}
        else if(!isMale && salary>5000) {
        		tax=salary*0.03;
        }
        else {
        		tax=salary*0.01;
        }
        System.out.println(salary-tax);
    }
}
*/
//Q11.	Accept 3 digit number from user and do the sum of its digit .(do not use any loop)
/*
public class day1Qna {
    public static void main(String[] args) {

        int a,b;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        a = sc.nextInt();
        b=a%10;//3
        a=a/10;//21
        b+=a%10;//3+2
        a=a/10;//1
        b+=a%10;
        System.out.println(b);
        sc.close();

    }
}*/
//Q12.	Accept years of investment rate of interest and principal amount of investment find simple interest
/*
import java.util.Scanner;

public class day1Qna {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        double P = sc.nextDouble();

        System.out.print("Enter rate of interest: ");
        double R = sc.nextDouble();

        System.out.print("Enter number of years: ");
        double T = sc.nextDouble();

        double SI = (P * R * T) / 100;

        System.out.println("Simple Interest = " + SI);

        sc.close();
    }
}
*/
//Q13.	Problem: Given the length of four sides determine whether they can be used to create a polygon 
//and determine if that polygon is a square. A polygon can be created if no single side is greater 
//than the sum of the other three sides. Display a ONE when the status (polygon or square) is confirmed 
//and ZERO when the status cannot be confirmed.
/*
 * Example Execution #2:
Enter the length of the four sides: 5 5 5 5
Length of sides: 5, 5, 5, 5
Polygon status: 1
Square status: 1
 */
/*
public class day1Qna {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 4 sides: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        
        System.out.println(a+","+b+","+c+","+d);
        boolean isPolygon=
        		a<=b+c+d &&
        		b<=a+c+d &&
        		c<=a+b+d &&
        		d<=a+b+c ;
        
        boolean isSquare=
        		a==b&&b==c&&c==d;
        
        int PolygonStatus=isPolygon ? 1:0;
        int SquareStatus=isSquare ? 1:0;
        
        System.out.println("PolygonStatus :"+PolygonStatus);
        System.out.println("SquareStatus :"+SquareStatus);
    }
}*/


