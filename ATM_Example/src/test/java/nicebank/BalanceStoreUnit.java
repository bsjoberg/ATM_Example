package nicebank;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BalanceStoreUnit {

	@Before
	public void setUp() throws Exception {
		BalanceStore.clear();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd100() {
		BalanceStore.setBalance(new Money(100, 00));
		
		assertEquals(new Money(100,00), BalanceStore.getBalance());
	}

}
