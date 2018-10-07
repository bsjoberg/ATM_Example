package nicebank;

import cucumber.api.java.en.When;
import support.KnowsTheDomain;

public class TellerSteps {
	KnowsTheDomain helper;
	
	public TellerSteps(KnowsTheDomain helper) {
		this.helper = helper;
	}
	
	@When("^I request \\$(\\d+)$")
	public void iRequest$(int dollars) throws Throwable {
	    helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
	}
}
