package nicebank;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	KnowsTheDomain helper;
	

	
	public Steps () {
		helper = new KnowsTheDomain();
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
