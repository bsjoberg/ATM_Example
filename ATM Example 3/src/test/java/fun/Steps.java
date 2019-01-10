package fun;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	class Account {
		private int balance = 0;
		
		public void deposit(int amount) {
			balance += amount;
		}
		
		public int getBalance() {
			return balance;
		}
	}
	
	@Given("^I have deposited \\$(\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(int amount) throws Throwable {
	    Account myAccount = new Account();
	    myAccount.deposit(amount);
	    
	    Assert.assertEquals(amount, myAccount.getBalance());
	}

	@When("^I request \\$(\\d+)$")
	public void iRequest$(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
