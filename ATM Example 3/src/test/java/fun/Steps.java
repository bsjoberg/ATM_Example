package fun;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import transforms.MoneyConverter;

public class Steps {
	private Account myAccount;
	
	class Account {
		private Money balance;
		
		Account() {
			balance = new Money();
		}
		
		public void deposit(Money amount) {
			balance = balance.add(amount);
		}
		
		public Money getBalance() {
			return balance;
		}
	}
	
	class Teller {
		public void withdrawFrom(Account account, int dollars) {
			
		}
	}
	
	@Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class)Money amount) throws Throwable {
	    myAccount = new Account();
	    myAccount.deposit(amount);
	    
	    Assert.assertEquals("Incorrect Account Balance - ", amount, myAccount.getBalance());
	}

	@When("^I withdraw \\$(\\d+)$")
	public void iWithdraw$(int amount) throws Throwable {
		Teller teller = new Teller();
		teller.withdrawFrom(myAccount, amount);
	}

	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
