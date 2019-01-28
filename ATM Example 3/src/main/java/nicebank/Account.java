package nicebank;

public class Account {
	private Money balance;
	private TransactionQueue queue = new TransactionQueue();
	
	public Account() {
		balance = new Money();
	}
	
	public void credit(Money amount) {
		queue.write("+" + amount.toString());
	}
	
	public Money getBalance() {
		return BalanceStore.getBalance();
	}

	public boolean hasSufficientFunds(int dollars) {
		if (getBalance().dollars() >= dollars) {
			return true;
		}
		else
			return false;
	}

	public void debit(int dollars) {
		Money amount = new Money(dollars, 0);
		queue.write("-" + amount.toString());
	}
}
