package nicebank;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BalanceStoreUnit {
	private static String BALANCE_FILE_PATH = "./balance";
	
	@Before
	public void setUp() throws Exception {
		BalanceStore.setBalance(new Money(0,0));
	}

	@After
	public void tearDown() throws Exception {
		new File(BALANCE_FILE_PATH).delete();
	}

	@Test
	public void testBalanceZero() {
		Assert.assertEquals(new Money(0,0), BalanceStore.getBalance());
	}
	
	@Test
	public void testAdd20Balance20() {
		BalanceStore.setBalance(new Money (20,0));
		Assert.assertEquals(BalanceStore.getBalance(), new Money(20,0));
	}

}
