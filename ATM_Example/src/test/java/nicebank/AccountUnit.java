package nicebank;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountUnit {

	@Test
	public void testDeposit100() {
		Account account = new Account();
		Money amount = new Money(100, 00);
		account.credit(amount);
		assertEquals(new Money(100, 00), account.getBalance());
	}

	@Test 
	public void testDeposit200() {
		Account account = new Account();
		Money amount = new Money(200, 00);
		account.credit(amount);
		assertEquals(new Money(200, 00), account.getBalance());
	}
	
	@Test
	public void testDebit100from200() {
		Account account = new Account();
		Money amount = new Money(200, 00);
		account.credit(amount);
		account.debit(100);
		assertEquals(new Money(100, 00), account.getBalance());
	}
	
	@Test
	public void testDebit200from100() {
		Account account = new Account();
		Money amount = new Money(100, 00);
		account.credit(amount);
		account.debit(200);
		assertEquals(new Money(100, 00), account.getBalance());
		assertFalse(account.sufficientFunds());
	}
}
