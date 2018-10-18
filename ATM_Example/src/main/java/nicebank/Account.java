package nicebank;

public class Account {
	private TransactionQueue queue = new TransactionQueue();
	private boolean sufficientFunds = false; 
	
	public void credit(Money amount) {
		queue.write("+" + amount.toString());
	}

	public Money getBalance() {
		return BalanceStore.getBalance();
	}

	public void debit(int dollars) {
		Money amount = new Money(dollars, 0);
		queue.write("-" + amount.toString());
	}

	public boolean sufficientFunds() {
		return sufficientFunds;
	}
}
