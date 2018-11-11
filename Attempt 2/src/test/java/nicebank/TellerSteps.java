package nicebank;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.KnowsTheDomain;

public class TellerSteps {
	KnowsTheDomain helper;
	boolean sufficientFunds = true;
	
	public TellerSteps(KnowsTheDomain helper) {
		this.helper = helper;
	}
	
	@When("^I withdraw \\$(\\d+)$")
	public void iRequest$(int amount) throws Throwable {
	    sufficientFunds = helper.getTeller().withdrawFrom(helper.getMyAccount(), amount);
	}
	
	@When("^I check my balance$")
	public void iCheckMyBalance() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^I should be notified of insufficient funds$")
	public void iShouldBeNotifiedOfInsufficientFunds() throws Throwable {
	    Assert.assertFalse(sufficientFunds);
	}
}
