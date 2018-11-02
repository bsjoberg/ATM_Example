package nicebank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountUnit {
	private Thread transactionProcessorThread;
	private int SLEEP_TIME = 500;

	@Before
	public void setUp() {
		BalanceStore.clear();
		TransactionQueue.clear();
		
		transactionProcessorThread = new Thread() {
			public void run() {
				TransactionProcessor processor = new TransactionProcessor();
				processor.process();
			}
		};

		transactionProcessorThread.start();
	}

	@Test
	public void testDeposit100() {
		Account account = new Account();
		Money amount = new Money(50, 00);
		account.credit(amount);
		
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals(new Money(50, 00), account.getBalance());
	}

	@Test
	public void testDeposit300() {		
		Account account = new Account();
		Money amount = new Money(300, 00);
		account.credit(amount);

		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		assertEquals(new Money(300, 00), account.getBalance());
	}

	@Test
	public void testDebit100from200() {
		Account account = new Account();
		Money amount = new Money(200, 00);
		account.credit(amount);
		
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		account.debit(100);
		
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals(new Money(100, 00), account.getBalance());
	}

	@Test
	public void testDebit200from150() {
		Account account = new Account();
		Money amount = new Money(150, 00);
		account.credit(amount);
		
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		boolean sufficientFunds = account.debit(200);
		
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals(new Money(150, 00), account.getBalance());
		assertFalse(sufficientFunds);
	}

	@After
	public void tearDown() {
		transactionProcessorThread.interrupt();
	}
}
