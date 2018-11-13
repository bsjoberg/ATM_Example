package nicebank;

import org.junit.Assert;

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
	    helper.getTeller().withdrawFrom(helper.getMyAccount(), amount);
	}
	
	@When("^I check my balance$")
	public void iCheckMyBalance() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //helper.getTeller().checkBalance(helper.getMyAccount());
	}
	
	@Then("^I should be notified of insufficient funds$")
	public void iShouldBeNotifiedOfInsufficientFunds() throws Throwable {
	    Assert.assertFalse(helper.getTeller().hasSufficientFunds());
	}
	
	@Then("^I should see that my balance is \\$(\\d+)\\.(\\d+)$")
	public void iShouldSeeThatMyBalanceIs$(int dollars, int cents) throws Throwable {
	    Assert.assertEquals(helper.getTeller().checkBalance(helper.getMyAccount()), new Money(dollars, cents).toString());
	}
}
