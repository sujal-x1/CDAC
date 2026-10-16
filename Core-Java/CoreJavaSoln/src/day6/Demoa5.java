package day6;

public class Demoa5 {//Bank account class
	int accountNumber=2213;
	String accountHolder="Hunger";
	 double balance;
	
	public double withdraw(double amount) throws InsufficientFundsException {
		if(amount>balance) {
			throw new InsufficientFundsException("The Funds Are Not Sufficient");
		}
		else {
			balance=balance-amount;
			return balance;
		}
	}
	public void deposit(double amount) {
	    balance = balance + amount;
	}

	
	public static void main(String[] args) {
		Demoa5 a = new Demoa5();
		
		a.deposit(100);

		try {
			a.withdraw(123);
		}
		catch(InsufficientFundsException ie){
			System.out.println(ie.getMessage());
		}
		System.out.println("balance after deposit"+a.balance);
	}

}
class InsufficientFundsException extends Exception{
	InsufficientFundsException(String message){
		super (message);
	}
}
