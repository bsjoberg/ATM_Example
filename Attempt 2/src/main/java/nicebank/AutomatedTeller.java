package nicebank;

public class AutomatedTeller implements Teller {
	private CashSlot cashSlot;
	private boolean sufficientFunds = false;
	
	public AutomatedTeller(CashSlot cashSlot) {
		this.cashSlot = cashSlot;
	}
	
	public AutomatedTeller() {
		
	}
	
	/**
	 * Returns false if insufficient funds exist
	 * 
	 * @param myAccount
	 * @param dollars
	 * @return 		false if insufficient funds exist
	 */
	public void withdrawFrom(Account myAccount, int dollars) {
		sufficientFunds = myAccount.debit(dollars);
		if (sufficientFunds)
			cashSlot.dispense(dollars);
	}
	
	public String checkBalance(Account account) {
		return account.getBalance().toString();
	}

	public boolean hasSufficientFunds() {
		return sufficientFunds;
	}
}
