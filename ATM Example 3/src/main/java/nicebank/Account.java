package nicebank;

import org.javalite.activejdbc.Model;

public class Account extends Model {
	  private TransactionQueue queue = new TransactionQueue();

	  public void credit(Money amount) {
	      queue.write("+" + amount.toString() + "," + getNumber());
	  }
	  
	  public void debit(int dollars) {
	      Money amount = new Money(dollars, 0);
	      queue.write("-" + amount.toString() + "," + getNumber());
	  }
	  
	  public int getNumber() {
	      return getInteger("number");
	  }

	  public Money getBalance() {
	      return new Money(getString("balance"));
	  }	

	  public void setBalance(Money amount) {
	      setString("balance", amount.toString().substring(1));
	      saveIt();
	  }

	public boolean hasSufficientFunds(int dollars) {
		if (getBalance().dollars() >= dollars) {
			return true;
		}
		else
			return false;
	}
}
