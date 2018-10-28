package nicebank;

import java.io.File;

import org.junit.After;
import org.junit.Test;

import junit.framework.TestCase;

public class TransactionQueueUnit extends TestCase {
	
	public void setUp() throws Exception {
		TransactionQueue.clear();
	}
	
	@Test
	public void testWriteAdd() {
		TransactionQueue queue = new TransactionQueue();
		queue.write("+" + "$100.00");
		
		// Check that file exists;
		File messagesFolder = new File(TransactionQueue.MESSAGES_FOLDER);
		File[] messages = messagesFolder.listFiles();
		assertTrue(messages.length == 1);
	}
	
	@Test
	public void testReadAdd200() {
		TransactionQueue queue = new TransactionQueue();
		queue.write("+" + "$200.00");
		
		assertEquals("+$200.00", queue.read());
	}
	
	@Test
	public void testReadAdd300() {
		TransactionQueue queue = new TransactionQueue();
		queue.write("+" + "$300.00");
		
		assertEquals("+$300.00", queue.read());
	}
	
	@Test 
	public void testMinus200() {
		TransactionQueue queue = new TransactionQueue();
		queue.write("-" + "$200.00");
		
		assertEquals("-$200.00", queue.read());
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
