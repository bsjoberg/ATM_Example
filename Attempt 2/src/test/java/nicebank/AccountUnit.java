package nicebank;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountUnit {
	Account myAccount;
	
	@Before
	public void setUp() throws Exception {
		myAccount = new Account();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeposit100() {
		myAccount.deposit(new Money("$100.00"));
		
		Assert.assertEquals(new Money(100, 00), myAccount.getBalance());
	}

	@Test
	public void testDebit100from200() {
		myAccount.deposit(new Money("$200.00"));
		
		Assert.assertEquals(new Money(200, 00), myAccount.getBalance());
		
		myAccount.debit(100);
		
		Assert.assertEquals(new Money(100, 00), myAccount.getBalance());
	}
	
	@Test
	public void testDebit200from150() {
		myAccount.deposit(new Money("$150.00"));
		
		Assert.assertEquals(new Money(150, 00), myAccount.getBalance());
		
		boolean sufficientFunds = myAccount.debit(200);
		
		Assert.assertEquals(new Money(150, 00), myAccount.getBalance());
		Assert.assertFalse(sufficientFunds);
	}
}
