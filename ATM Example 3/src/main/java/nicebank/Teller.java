package nicebank;

public class Teller {
	private CashSlot cashSlot;
	
	public Teller(CashSlot cashSlot) {
		this.cashSlot = cashSlot;
	}
	
	public void withdrawFrom(Account account, int dollars) {
		if (account.hasSufficientFunds(dollars))
			cashSlot.dispense(dollars);
		else
			System.out.println("Insufficient Funds");
	}
}