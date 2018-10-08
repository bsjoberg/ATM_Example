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
	
	@When("^I (?:request|withdraw) \\$(\\d+)$")
	public void iRequest$(int dollars) throws Throwable {
	    helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
	}
	
	@Then("^nothing should be dispensed$")
	public void nothingShouldBeDispensed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}