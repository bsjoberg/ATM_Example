package nicebank;

public interface Teller {
	boolean withdrawFrom(Account account, int dollars);
	
	String checkBalance(Account account);
}