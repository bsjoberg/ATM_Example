package nicebank;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;

import junit.framework.TestCase;

public class TransactionQueueUnit extends TestCase {
	
	@Test
	public void testWriteAdd() {
		TransactionQueue queue = new TransactionQueue();
		queue.write("+" + "$100");
		
		// Check that file exists;
		File messagesFolder = new File(TransactionQueue.MESSAGES_FOLDER);
		File[] messages = messagesFolder.listFiles();
		assertTrue(messages.length == 1);
	}
	
	@After
	public void tearDown() throws Exception {
		try {
			FileUtils.deleteDirectory(new File(TransactionQueue.MESSAGES_FOLDER));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
