package practicallearning;

public class ExceptionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
//		BankAccount a = new BankAccount();
		BankAccount a2 = new BankAccount();
//		a.accountHolder="Sujal";
//		a.accountNumber=123;
//		a.balance=99999.99;
		a2.accountHolder="gippi";
		a2.accountNumber=223;
		a2.balance=9.99;
		try {
			a2.withdraw(20);
		} catch (InsufficientFundsException e) {
			System.out.println(e);;
		}
		a2.deposit(44);
		//a.deposit(100);
		System.out.println(a2.balance+" a2 ka balance");
//		System.out.println(a.balance+" mera balance");
	}
}


