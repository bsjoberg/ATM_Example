package nicebank;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountUnit {

	@Test
	public void testDeposit100() {
		Account account = new Account();
		account.deposit(100);
		assertEquals(100, account.balance());
	}

	@Test 
	public void testDeposit200() {
		Account account = new Account();
		account.deposit(200);
		assertEquals(200, account.balance());
	}
}
