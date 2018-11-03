package nicebank;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import support.KnowsTheDomain;

public class AccountSteps {
	KnowsTheDomain helper;
	
	public AccountSteps(KnowsTheDomain helper) {
		this.helper = helper;
	}
	
	@Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
	public void myAccountHasBeenCreditedWith$(Money amount) throws Throwable {
	    helper.getMyAccount().credit(amount);
	    
	    Assert.assertEquals("Incorrect account balance - ", amount, helper.getMyAccount().getBalance());
	}
	
	@Then("^the balance of my account should be \\$(\\d+)\\.(\\d+)$")
	public void theBalanceOfMyAccountShouldBe$(int dollars, int cents) throws Throwable {
	    Assert.assertEquals(new Money(dollars, cents), helper.getMyAccount().getBalance());
	}
}
