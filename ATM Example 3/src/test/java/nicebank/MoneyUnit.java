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
	
	@Test
	public void testOver200Cents() {
		Money money = new Money(0, 210);
		Assert.assertEquals(2, money.dollars());
		Assert.assertEquals(10, money.cents());
	}
	
	@Test 
	public void testAddCentsThatAddsADollar() {
		Money money = new Money (1, 50);
		money = money.add(new Money(0, 75));
		Assert.assertEquals(new Money(2, 25), money);
	}
	
	@Test
	public void testAddCentsThatAddsTwoDollars() {
		Money money = new Money (1, 50);
		money = money.add(new Money(0, 175));
		Assert.assertEquals(new Money(3, 25), money);		
	}
	
	@Test
	public void testMinusDollarsAndCents() {
		Money money = new Money (2, 75);
		money = money.minus(new Money(1, 95));
		Assert.assertEquals(new Money(0, 80), money);
	}
	
	@Test
	public void testMinusCentsThatReduceByADollar() {
		Money money = new Money (1, 50);
		money = money.minus(new Money(0, 75));
		Assert.assertEquals(new Money(0, 75), money);
	}
	
	@Test
	public void testDollarAndCentsMoneyStringContructorWithDollarSign() {
		Money money = new Money("$100.10");
		Assert.assertEquals(new Money(100, 10), money);
	}
}
