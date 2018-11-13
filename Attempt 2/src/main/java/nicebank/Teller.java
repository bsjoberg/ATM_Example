package nicebank;

public interface Teller {
	boolean hasSufficientFunds();
	
	void withdrawFrom(Account account, int dollars);
	
	String checkBalance(Account account);
}