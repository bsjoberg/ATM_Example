package nicebank;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.KnowsTheDomain;

public class TellerSteps {
	KnowsTheDomain helper;
	
	public TellerSteps(KnowsTheDomain helper) {
		this.helper = helper;
	}
	
	@When("^I withdraw \\$(\\d+)$")
	public void iRequest$(int amount) throws Throwable {
	    Teller teller = new Teller(helper.getCashSlot());
	    teller.withdrawFrom(helper.getMyAccount(), amount);
	}
	
	@Then("^I should be notified of insufficient funds$")
	public void iShouldBeNotifiedOfInsufficientFunds() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
