package nicebank;

public class AutomatedTeller implements Teller {
	private CashSlot cashSlot;
	
	public AutomatedTeller (CashSlot cashSlot) {
		this.cashSlot = cashSlot;
	}
	
	public void withdrawFrom(Account myAccount, int dollars) {
		if (myAccount.debit(dollars))
			cashSlot.dispense(dollars);
	}

}
