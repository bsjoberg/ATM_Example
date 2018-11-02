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
	public void convertString100withCents() {
		Money money = new Money("$100.00");
		Assert.assertEquals(new Money(100, 00), money);
	}
	
	@Test
	public void add100to200() {
		Money money = new Money("200.00");
		money = money.add(new Money(100,00));
		Assert.assertEquals(new Money(300,00), money);
	}
	
	@Test
	public void minus150from400() {
		Money money = new Money("$400.00");
		money = money.minus(new Money(150, 00));
		Assert.assertEquals(new Money(250, 00), money);
	}
	
	@Test
	public void parseDollarsCents() {
		Money money = new Money("$211.23");
		Assert.assertEquals(new Money(00, 23).cents(), money.cents());
		Assert.assertEquals(new Money(211, 00).dollars(), money.dollars());
	}
}
