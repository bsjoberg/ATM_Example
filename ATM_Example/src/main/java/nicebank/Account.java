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

	/**
	 * 
	 * @param dollars
	 * @return true if sufficient funds exist, false otherwise
	 */
	public boolean debit(int dollars) {
		Money amount = new Money(dollars, 0);
		
		// Before writing, check for sufficient funds
		if (dollars <= getBalance().dollars()) {
			queue.write("-" + amount.toString());
			sufficientFunds = true;
			return sufficientFunds;
		} else {
			sufficientFunds = false;
			return sufficientFunds;
		}
	}
	
	public boolean hasSufficientFunds() {
		return sufficientFunds;
	}
}
