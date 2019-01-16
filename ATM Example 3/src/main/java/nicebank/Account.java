package nicebank;

public class Account {
	private Money balance;
	
	public Account() {
		balance = new Money();
	}
	
	public void deposit(Money amount) {
		balance = balance.add(amount);
	}
	
	public Money getBalance() {
		return balance;
	}

	public boolean hasSufficientFunds(int dollars) {
		if (balance.dollars() >= dollars) {
			return true;
		}
		else
			return false;
	}

	public void withdraw(int dollars) {
		balance = balance.minus(new Money(dollars, 0));
	}
}
