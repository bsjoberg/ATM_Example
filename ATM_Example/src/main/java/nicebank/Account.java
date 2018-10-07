package nicebank;

public class Account {
	int balance = 0;
	
	public void deposit (int amount) {
		balance += amount;
	}

	public int balance() {
		return balance;
	}
}
