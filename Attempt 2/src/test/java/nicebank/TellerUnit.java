package nicebank;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import support.KnowsTheDomain;

public class TellerUnit {
	KnowsTheDomain helper;

	@Before
	public void setUp() throws Exception {
		helper = new KnowsTheDomain();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsufficientFunds() {
		helper.getMyAccount().credit(new Money(40,00));
		
		AutomatedTeller teller = new AutomatedTeller(helper.getCashSlot());
		teller.withdrawFrom(helper.getMyAccount(), 50);
		
		Assert.assertFalse(teller.hasSufficientFunds());
		Assert.assertEquals(new Money(40,00), helper.getMyAccount().getBalance());
	}

	@Test
	public void testBalance() {
		helper.getMyAccount().credit(new Money(60,00));
		Assert.assertEquals(new Money(60,00), helper.getMyAccount().getBalance());
	}
}
