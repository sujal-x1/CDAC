package day2;
import java.util.Scanner;
public class BankAccountSystem {
	static Scanner sc=new Scanner(System.in);
	private int accountNumber;
	private String accountHolderName;
	private  double balance;
	private static String bankName="Private bank";
	//constructor
	BankAccountSystem(int accountNumber,String Holder,double balance){
		this.accountNumber=accountNumber;
		this.accountHolderName=Holder;
		this.balance=balance;
	}
	
	//static methods
	 int deposit() {
		System.out.println("enter deposit amount");
		int num=sc.nextInt();
		balance+=num;
		return num;
	}
	
	 int withdraw() {
		System.out.println("how much would you like to draw");
		int num=sc.nextInt();
		balance-=num;
		return num;
	}
	
	void displayDetails() {
		System.out.println("accountNumber"+"="+accountNumber);
		System.out.println("accountHolderName"+"="+accountHolderName);
		System.out.println("balance"+"="+balance);
		System.out.println("bankName"+"="+bankName);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccountSystem a1= new BankAccountSystem(123,"sujal",99999.99);
		BankAccountSystem a2= new BankAccountSystem(23,"dinanath",249.98);
		BankAccountSystem a3= new BankAccountSystem(3,"chintya",5945.23);
		a1.displayDetails();
		a1.deposit();
		System.out.println();
		a1.displayDetails();
		System.out.println();

		a2.displayDetails();
		System.out.println();

		a2.withdraw();
		System.out.println();
		a2.displayDetails();
		System.out.println();

		a3.displayDetails();
		
		
	}

}
