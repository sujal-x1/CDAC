package practicallearning;

public class BankAccount {
	int accountNumber;
	String accountHolder;
	double balance;
	
	void withdraw(double amount) throws InsufficientFundsException   
	{
		if(balance<amount) {
			throw new InsufficientFundsException("chal be gareeb");
		}
		else 
			balance-=amount;
	}
	void deposit(double amount) {
		balance+=amount;
	}
}
