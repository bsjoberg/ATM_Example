package nicebank;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	KnowsTheDomain helper;
	
	class KnowsTheDomain {
		private Account myAccount;
		private CashSlot cashSlot;
		
		public Account getMyAccount() {
			if (myAccount == null) {
				myAccount = new Account();
			}
			
			return myAccount;
		}
		
		public CashSlot getCashShot() {
			if (cashSlot == null) {
				cashSlot = new CashSlot();
			}
			
			return cashSlot;
		}
	}
	
	public Steps() {
		helper = new KnowsTheDomain();
	}
	
	@Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(Money amount) throws Throwable {
	    helper.getMyAccount().deposit(amount);
	    
	    Assert.assertEquals("Incorrect account balance - ", amount, helper.getMyAccount().getBalance());
	}

	@When("^I withdraw \\$(\\d+)$")
	public void iRequest$(int amount) throws Throwable {
	    Teller teller = new Teller(helper.getCashShot());
	    teller.withdrawFrom(helper.getMyAccount(), amount);
	}

	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int dollars) throws Throwable {
	    Assert.assertEquals("Incorrect amount dispensed - ", dollars, helper.getCashShot().contents());
	}	
}