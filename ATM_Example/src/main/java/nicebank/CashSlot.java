package nicebank;

public class CashSlot {
	private int contents = 0;
	
	public int getContents() {
		return contents;
	}

	public void dispense(int dollars) {
		contents = dollars;
	}

}
