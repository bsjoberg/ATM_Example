package nicebank;

class CashSlot {
	private int contents;
	
	public int contents() {
		return contents;
	}
	
	public void dispense(int dollars) {
		contents = dollars;
	}
}