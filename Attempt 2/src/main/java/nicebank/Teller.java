package nicebank;

import nicebank.Steps.Account;
import nicebank.Steps.CashSlot;

public class Teller {
	private CashSlot cashSlot;
	
	public Teller(CashSlot cashSlot) {
		this.cashSlot = cashSlot;
	}
	
	public void withdrawFrom(Account myAccount, int dollars) {
		cashSlot.dispense(dollars);
	}

}
