package nicebank;

public class Account {
	private Money balance = new Money();
	
	public void deposit(Money amount) {
		balance = balance.add(amount);
	}
	
	public Money getBalance() {
		return balance;
	}

	public boolean debit(int amount) {
		boolean sufficientFunds = true;
		
		// check if sufficient funds exist
		if (getBalance().dollars() >= amount) {
			balance = balance.minus(new Money(amount, 00));
			sufficientFunds = true;
		}
		else
			sufficientFunds = false;
		
		return sufficientFunds;
	}
}