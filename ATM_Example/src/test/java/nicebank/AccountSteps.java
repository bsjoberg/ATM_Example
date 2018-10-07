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
	
	@Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(Money amount) throws Throwable {
	    helper.getMyAccount().deposit(amount);
	    
	    Assert.assertEquals("Incorrect Account Balance - ", amount, helper.getMyAccount().getBalance());
	}
	
	@Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
	public void theBalanceOfMyAccountShouldBe$(Money balance) throws Throwable {
		Assert.assertEquals("Incorrect Account Balance - ", balance, helper.getMyAccount().getBalance());
	}
}
