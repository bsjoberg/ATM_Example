package nicebank;

import org.junit.Assert;
import org.junit.Test;

public class MoneyUnit {

	@Test
	public void testParseOfStringToMoney() {
		Money money = new Money("$100.50");
		Assert.assertEquals(100, money.dollars());
		Assert.assertEquals(50, money.cents());
	}
	
	@Test
	public void testAddMoney() {
		Money money = new Money("$50.49");
		money = money.add(new Money("$20.10"));
		
		Assert.assertTrue(money.equals(new Money("$70.59")));
	}
}
