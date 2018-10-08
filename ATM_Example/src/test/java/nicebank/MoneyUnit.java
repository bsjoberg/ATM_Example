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

}
