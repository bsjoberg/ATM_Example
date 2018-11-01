package nicebank;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TransactionProcessorUnit {
	private Thread transactionProcessorThread;
	private int SLEEP_TIME = 250;
	
	@Before
	public void setUp() throws Exception {
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

	@After
	public void tearDown() throws Exception {
		transactionProcessorThread.interrupt();
	}

	@Test
	public void testWrite100() {
		// Write a message
		TransactionQueue queue = new TransactionQueue();
		queue.write("+" + "$100.00");
		
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals(new Money("$100.00"), BalanceStore.getBalance());
	}

	@Test
	public void testZeroWrite200() {
		TransactionQueue queue = new TransactionQueue();
		
		assertEquals(new Money("$0.00"), BalanceStore.getBalance());
		
		queue.write("+" + "$200.00");
		
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals(new Money("$200.00"), BalanceStore.getBalance());
	}
}
