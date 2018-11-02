package nicebank;

import cucumber.api.java.en.When;
import support.KnowsTheDomain;

public class TellerSteps {
	KnowsTheDomain helper;
	
	public TellerSteps() {
		helper = new KnowsTheDomain();
	}
	
	@When("^I withdraw \\$(\\d+)$")
	public void iRequest$(int amount) throws Throwable {
	    Teller teller = new Teller(helper.getCashSlot());
	    teller.withdrawFrom(helper.getMyAccount(), amount);
	}
}
