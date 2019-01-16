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
}
