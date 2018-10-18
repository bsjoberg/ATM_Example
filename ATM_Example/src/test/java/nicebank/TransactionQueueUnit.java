package nicebank;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class TransactionQueueUnit {
	
	@Test
	public void testWriteAdd() {
		TransactionQueue queue = new TransactionQueue();
		queue.write("+" + "$100");
		
		// Check that file exists;
		File messagesFolder = new File(TransactionQueue.MESSAGES_FOLDER);
		File[] messages = messagesFolder.listFiles();
		assertTrue(messages.length == 1);
	}
}
