package nicebank;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyUnit {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOver100Cents() {
		Money money = new Money(0, 105);
		Assert.assertEquals(1, money.dollars());
		Assert.assertEquals(5, money.cents());
	}

}
