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
		helper.getMyAccount().deposit(new Money(40,00));
		
		Teller teller = new Teller(helper.getCashSlot());
		
		Assert.assertFalse(teller.withdrawFrom(helper.getMyAccount(), 50));
		Assert.assertEquals(new Money(40,00), helper.getMyAccount().getBalance());
	}

}
