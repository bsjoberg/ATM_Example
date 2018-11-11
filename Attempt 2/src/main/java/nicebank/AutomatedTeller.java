package nicebank;

public class AutomatedTeller implements Teller {
	private CashSlot cashSlot;
	
	public AutomatedTeller(CashSlot cashSlot) {
		this.cashSlot = cashSlot;
	}
	
	/**
	 * Returns false if insufficient funds exist
	 * 
	 * @param myAccount
	 * @param dollars
	 * @return 		false if insufficient funds exist
	 */
	public boolean withdrawFrom(Account myAccount, int dollars) {
		boolean sufficientFunds = false;
		
		sufficientFunds = myAccount.debit(dollars);
		if (sufficientFunds)
			cashSlot.dispense(dollars);
		
		return sufficientFunds;
	}
}
