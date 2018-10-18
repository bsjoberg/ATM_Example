package nicebank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TransactionQueue {
	public static String MESSAGES_FOLDER = "./messages";
	private static String MESSAGE_FILE_PATH = "%s/$03d";
	private int nextId = 1;
	
	public TransactionQueue () {
		new File(MESSAGES_FOLDER).mkdirs();
	}
	
	public void write(String transaction) {
		String messageFilePath = 
				String.format(MESSAGE_FILE_PATH, MESSAGES_FOLDER, nextId);
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(messageFilePath, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		writer.println(transaction);
		writer.close();
		
		nextId++;
	} 

}
