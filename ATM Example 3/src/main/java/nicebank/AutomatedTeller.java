package nicebank;

public class AutomatedTeller implements Teller {
	private CashSlot cashSlot;
	
	public AutomatedTeller(CashSlot cashSlot) {
		this.cashSlot = cashSlot;
	}
	
	/* (non-Javadoc)
	 * @see nicebank.Teller#withdrawFrom(nicebank.Account, int)
	 */
	public void withdrawFrom(Account account, int dollars) {
		if (account.hasSufficientFunds(dollars)) {
			account.debit(dollars);
			cashSlot.dispense(dollars);
		}
		else {
			System.out.println("Insufficient Funds");
		}
	}
}