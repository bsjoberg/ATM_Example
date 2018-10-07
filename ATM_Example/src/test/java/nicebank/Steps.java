package nicebank;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	KnowsMyDomain helper;
	
	class KnowsMyDomain {
		private Account myAccount;
		private CashSlot cashSlot;
		private Teller teller;
		
		public Account getMyAccount() {
			if (myAccount == null) {
				myAccount = new Account();
			}
			
			return myAccount;
		}
		
		public Teller getTeller() {
			if (teller == null)
				teller = new Teller(getCashSlot());
			return teller;
		}
		
		public CashSlot getCashSlot() {
			if (cashSlot == null) {
				cashSlot = new CashSlot();
			}
				
			return cashSlot;
		}
	}
	
	public Steps () {
		helper = new KnowsMyDomain();
	}
	
	@Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(Money amount) throws Throwable {
	    helper.getMyAccount().deposit(amount);
	    
	    Assert.assertEquals("Incorrect Account Balance - ", amount, helper.getMyAccount().getBalance());
	}

	@When("^I request \\$(\\d+)$")
	public void iRequest$(int dollars) throws Throwable {
	    helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
	}

	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int dollars) throws Throwable {
	    assertEquals("Incorrect amount dispensed - ", dollars, helper.getCashSlot().getContents());
	}
}
