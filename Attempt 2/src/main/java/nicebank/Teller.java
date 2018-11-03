package nicebank;

public class Teller {
	private CashSlot cashSlot;
	
	public Teller(CashSlot cashSlot) {
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
		// check if sufficient funds exist
		if (myAccount.getBalance().dollars() >= dollars) {
			sufficientFunds = true;
			myAccount.debit(dollars);
			cashSlot.dispense(dollars);
		}
		else
			sufficientFunds = false;

		return sufficientFunds;
	}
}
