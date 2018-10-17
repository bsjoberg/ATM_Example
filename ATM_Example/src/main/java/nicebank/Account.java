package nicebank;

public class Account {
	private Money balance = new Money();
	private boolean sufficientFunds = false; 
	
	public void credit(Money amount) {
		balance = balance.add(amount);
	}

	public Money getBalance() {
		return balance;
	}

	public void debit(int dollars) {
		if (dollars <= balance.dollars()) {
			balance = balance.minus(new Money(dollars, 0));
			sufficientFunds = true;
		} else
			sufficientFunds = false;
	}

	public boolean sufficientFunds() {
		return sufficientFunds;
	}
}
