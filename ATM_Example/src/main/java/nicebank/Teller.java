package nicebank;

public class Teller {
	private CashSlot cashSlot;
	
	public Teller (CashSlot cashSlot) {
		this.cashSlot = cashSlot;
	}
	
	public void withdrawFrom(Account myAccount, int dollars) {
		myAccount.debit(dollars);
		cashSlot.dispense(dollars);
	}

}
